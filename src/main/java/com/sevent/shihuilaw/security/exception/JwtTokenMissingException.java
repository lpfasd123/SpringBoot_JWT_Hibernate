package com.sevent.shihuilaw.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by xtb on 17/2/12.
 */
public class JwtTokenMissingException extends AuthenticationException {


    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
