package com.sevent.shihuilaw.security.service;

import com.sevent.shihuilaw.domain.User;


/**
 * Created by xtb on 17/2/12.
 */
public interface UserService {
    User save(User user);

    User findUserByUsername(String username);

    User findUserByEmailOrPhone(String email, String phone);

    User findUserByPhone(String phone);

}
