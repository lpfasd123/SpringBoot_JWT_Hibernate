package com.sevent.shihuilaw.security;

import com.sevent.shihuilaw.domain.User;

import java.io.Serializable;

/**
 * Created by xtb on 17/2/12.
 */
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;
    private String phone;
    private String code;
    private String email;
    private String usertype;
    private String accountPermissions;
    private String loadType;
    private String organization;
    private String source;
    private String smsId;

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getAccountPermissions() {
        return accountPermissions;
    }

    public void setAccountPermissions(String accountPermissions) {
        this.accountPermissions = accountPermissions;
    }

    public JwtAuthenticationRequest() {
        super();
    }


    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public JwtAuthenticationRequest(String username, String password, String phone, String code, String email,
                                    String usertype, String accountPermissions,String organization) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.code = code;
        this.email = email;
        this.usertype = usertype;
        this.accountPermissions = accountPermissions;
        this.organization = organization;
    }

    public static User toUser (JwtAuthenticationRequest jwtAuthenticationRequest){
        User user = new User();
        user.setUsername(jwtAuthenticationRequest.getUsername());
        user.setPassword(jwtAuthenticationRequest.getPassword());
        user.setUserType(jwtAuthenticationRequest.getUsertype());
        user.setEmail(jwtAuthenticationRequest.getEmail());
        user.setPhone(jwtAuthenticationRequest.getPhone());
        user.setAccountPermissions(jwtAuthenticationRequest.getAccountPermissions());
        user.setOrganization(jwtAuthenticationRequest.getOrganization());
        return user;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
