package com.kelvin.goodsagent.service;

import com.kelvin.goodsagent.common.exception.BizException;
import com.kelvin.goodsagent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 14:38
 * @description:
 */

public class BaseService {

    @Autowired
    private UserService userService;

    public User getCurrentUser() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByName(userDetails.getUsername());
        if (null == user) {
            throw new BizException("获取用户信息错误");
        }

        return user;
    }
}
