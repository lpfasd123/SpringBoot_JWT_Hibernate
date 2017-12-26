package com.sevent.shihuilaw.security;

/**
 * Created by xtb on 17/2/12.
 */

import com.sevent.shihuilaw.domain.User;
import com.sevent.shihuilaw.security.model.AuthorityName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user,String username) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = Calendar.getInstance().getTime();
        try {
            d = sdf.parse("21/12/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new JwtUser(
                user.getId(),
                username,
//                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(),
                user.getAccountPermissions(),
                user.getUserType(),
                user.getPhone(),
                user.getRealName(),
                user.getUsername(),
                true,
                d,
                user.getOrganization(),
                user.getSource()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities() {
        List<AuthorityName> authorities = new ArrayList<>();
        authorities.add(AuthorityName.ROLE_USER);
        authorities.add(AuthorityName.ROLE_ADMIN);
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }
}
