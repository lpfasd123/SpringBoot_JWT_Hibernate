package com.sevent.shihuilaw.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * Created by xtb on 17/2/12.
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {


    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}