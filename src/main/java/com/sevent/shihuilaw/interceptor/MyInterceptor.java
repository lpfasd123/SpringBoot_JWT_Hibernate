package com.sevent.shihuilaw.interceptor;

import com.sevent.shihuilaw.domain.User;
import com.sevent.shihuilaw.domain.UserLog;
import com.sevent.shihuilaw.security.JwtTokenUtil;
import com.sevent.shihuilaw.security.service.UserService;
import com.sevent.shihuilaw.service.UserLogService;
import com.sevent.shihuilaw.util.CreatUserLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Synchronize;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liupengfei on 2017/7/18.
 */
@Component
public class MyInterceptor implements HandlerInterceptor, AfterReturningAdvice {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final CreatUserLog creatUserLog = CreatUserLog.getCreatUserLog();
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private UserLogService userLogService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            logger.info(request.getRemoteAddr());
            logger.info(request.getRequestURI());
        try {
            String authToken = request.getHeader(this.tokenHeader);
            String username = jwtTokenUtil.getUsernameFromToken(authToken);

            if(username != null){
                User user = userService.findUserByUsername(username);
                creatUserLog.creatOrUpdateUserLog(request, user, authToken,
                        userLogService , userService);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {


    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

    }
}
