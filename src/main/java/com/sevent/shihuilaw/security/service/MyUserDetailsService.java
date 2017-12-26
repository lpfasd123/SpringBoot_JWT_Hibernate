package com.sevent.shihuilaw.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by liupengfei on 2017/6/30.
 */
public interface MyUserDetailsService extends UserDetailsService {
    UserDetails loadUserByUsername(String username,String source) throws UsernameNotFoundException;

}
