package com.sevent.shihuilaw.security.service;

import com.sevent.shihuilaw.security.JwtUser;

import java.io.Serializable;

/**
 * Created by xtb on 17/2/12.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final JwtUser user;




    public JwtAuthenticationResponse(String token, JwtUser user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }

    public JwtUser getUser() {
        return user;
    }
}
