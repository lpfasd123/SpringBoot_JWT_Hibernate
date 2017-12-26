package com.sevent.shihuilaw.security.service;

/**
 * Created by xtb on 17/2/12.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
