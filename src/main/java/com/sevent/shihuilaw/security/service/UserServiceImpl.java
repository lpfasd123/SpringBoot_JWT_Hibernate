package com.sevent.shihuilaw.security.service;


import com.sevent.shihuilaw.dao.UserDao;
import com.sevent.shihuilaw.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by xtb on 17/2/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findUserByUsername(String username) {

        return findUserByEmailOrPhone(username, username);
    }

    @Override
    public User findUserByEmailOrPhone(String email, String phone) {
        User user = userDao.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p =  cb.lessThan(root.get("id"),-1);
                if(phone != null){
                    Predicate p1 = cb.equal(root.get("phone"), phone);
                    p = cb.or(p,p1);
                }
                if(email != null){
                   Predicate p2 = cb.equal(root.get("email"), email);
                    p = cb.or(p,p2);
                }
                return p;
            }
        });
        return user.isUsable() == false ? null : user;
    }

    @Override
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }







}
