package com.sevent.shihuilaw.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by xtb on 17/2/12.
 */
public class JwtUser implements UserDetails {

    private final String id;
    private final String username;
    private final String password;
    private final String accountPermissions;
    private final String userType;
    private final String email;
    private final String phone;
    private final String realName;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final String viewUserName;
    private final String organization;
    private final String source;

    public JwtUser(
            String id,
            String username,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            String accountPermissions,
            String userType,
            String phone,

            String realName,
            String viewUserName,
            boolean enabled,
            Date lastPasswordResetDate,
            String organization,String source
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.accountPermissions = accountPermissions;
        this.userType = userType;

        this.realName = realName;
        this.phone = phone;
        this.enabled = enabled;
        this.viewUserName = viewUserName;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.organization = organization;
        this.source = source;

    }

    public String getSource() {
        return source;
    }

    public String getOrganization() {
        return organization;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public String getAccountPermissions() {
        return accountPermissions;
    }

    public String getUserType() {
        return userType;
    }

    public String getPhone() {
        return phone;
    }


    public String getRealName() {
        return realName;
    }


    public String getViewUserName() {
        return viewUserName;
    }
}
