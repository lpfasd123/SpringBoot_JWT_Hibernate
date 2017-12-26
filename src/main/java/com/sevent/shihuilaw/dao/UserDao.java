package com.sevent.shihuilaw.dao;



import com.sevent.shihuilaw.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by xtb on 17/2/24.
 */
@Repository

public interface UserDao extends JpaSpecificationExecutor<User>,
        JpaRepository<User, String> {
    @Transactional
    @Query("select count(u.id) from User u where u.phone = ?1 or u.email = ?2" )
    Integer checkPhoneOrEmail(String phone,String email);
    @Transactional
    @Query("select u from User u where u.id = ?1")
    User getOne(String id);

    @Transactional
    @Query("select u from User u where u.phone = ?1 or u.email = ?1")
    User findUserByPhone(String phone);
    @Transactional
    @Modifying
    @Query("update User u set u.logId = ?2 where u.id = ?1")
    Integer updateUser(String id, String logId);
    @Transactional
    @Modifying
    @Query("update User u set u.logId = null where u.id = ?1")
    Integer updateUser(String id);
} // class UserDao

