package com.sevent.shihuilaw.security.service;

import com.sevent.shihuilaw.domain.User;
import com.sevent.shihuilaw.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by xtb on 17/2/12.
 */
@Service
public class JwtUserDetailsServiceImpl implements MyUserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user,username);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username, String source) throws UsernameNotFoundException {

        return null;
    }
}
