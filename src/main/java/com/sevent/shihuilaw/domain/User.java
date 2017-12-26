package com.sevent.shihuilaw.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by xtb on 17/3/28.
 * 用户
 */
@Entity
@Table(name = "user", schema = "shihuilaw")
public class User {
    private String username;
    private String password;
    private Date lastTimeChangePassword;
    private String realName;
    private String phone;
    private String email;
    private Boolean usable;

    public User() {
    }


    public User(String username, String phone, String email,
                String password, Boolean usable,
                String realName) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.realName = realName;
        this.usable = usable;
    }

    public User(String username, String phone, String email, String password,
                 Date lastTimeChangePassword, String realName) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.lastTimeChangePassword = lastTimeChangePassword;
        this.realName = realName;
    }



    @Basic
    @Column(name = "usable")
    @org.hibernate.annotations.Type(type="yes_no")
    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Basic
    @Column(name = "user_name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Basic
    @Column(name = "last_time_change_password")
    public Date getLastTimeChangePassword() {
        return lastTimeChangePassword;
    }

    public void setLastTimeChangePassword(Date lastTimeChangePassword) {
        this.lastTimeChangePassword = lastTimeChangePassword;
    }
    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    @Override
    public String toString() {
        return super.toString()+"User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastTimeChangePassword=" + lastTimeChangePassword +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", usable='" + usable +"\'" +
                '}';
    }
}
