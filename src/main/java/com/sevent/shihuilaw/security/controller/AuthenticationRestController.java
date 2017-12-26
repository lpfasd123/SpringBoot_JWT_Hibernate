package com.sevent.shihuilaw.security.controller;

import com.octo.captcha.service.CaptchaServiceException;
import com.sevent.shihuilaw.domain.*;
import com.sevent.shihuilaw.security.*;
import com.sevent.shihuilaw.security.service.JwtAuthenticationResponse;
import com.sevent.shihuilaw.security.service.MyUserDetailsService;
import com.sevent.shihuilaw.security.service.SampleImageCaptcha;
import com.sevent.shihuilaw.security.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by xtb on 17/2/12.
 */
@RestController
public class AuthenticationRestController {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;


    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                       Device device,HttpServletRequest request) throws AuthenticationException {

        // Perform the security
        logger.info(authenticationRequest.getUsername()+ "     " + authenticationRequest.getPassword());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        logger.info(token);
        User u = userService.findUserByUsername(authenticationRequest.getUsername());
        JwtUser user = JwtUserFactory.create(u, authenticationRequest.getUsername());
        if(authenticationRequest.getSource() == null || !user.getSource().equals(authenticationRequest.getSource())){
            return  ResponseEntity.ok("登陆失败！");
        }

        return ResponseEntity.ok(new JwtAuthenticationResponse(token, user));
    }

    @GetMapping("${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken, user));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/forgetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody JwtAuthenticationRequest authenticationRequest,HttpServletRequest request) {
        // find the user
        User user = userService.findUserByPhone(authenticationRequest.getPhone());
        if (user == null) {
            // user not exists, throw an error
            throw  new RuntimeException("用户不存在");
        }
        HttpSession session = request.getSession();

        String smsCode = (String)session.getAttribute("smsCode");

        session.removeAttribute("smsCode");

        if(authenticationRequest.getCode().equals(smsCode)){
            user.setPassword(authenticationRequest.getPassword());
            userService.save(user);
            return ResponseEntity.ok("修改成功");
        }
        throw new RuntimeException("验证码错误");

    }

    @GetMapping("/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        // set content type as jpeg
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");


        BufferedImage bufferedImage = SampleImageCaptcha.getInstance()
                .getImageChallengeForID(request.getSession(true).getId());

        ServletOutputStream servletOutputStream = response.getOutputStream();

        // write the image to the servlet output stream

        ImageIO.write(bufferedImage, "jpg", servletOutputStream);
        try {
            servletOutputStream.flush();
        } finally {
            servletOutputStream.close();
        }
    }

    @GetMapping("/checkCode/{validateCode}")
    public String checkCode(@PathVariable("validateCode") String validateCode,HttpServletRequest request){
        Boolean isResponseCorrect =Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = request.getSession().getId();
        try {
            isResponseCorrect = SampleImageCaptcha.getInstance().validateResponseForID(captchaId,
                    validateCode);
            if(isResponseCorrect){
                return "success";
            }
        } catch (CaptchaServiceException e) {
            return "error";
        }
        return "error";
    }
}