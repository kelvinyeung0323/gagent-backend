package com.kelvin.goodsagent.seucurity;

import com.kelvin.goodsagent.entity.User;
import com.kelvin.goodsagent.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/10 0:20
 * @description:
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByName(username);
        if(StringUtils.isNotBlank(user.getRole())){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new SecUserDetails(user.getUsername(), user.getPassword(), authorities);

    }
}
