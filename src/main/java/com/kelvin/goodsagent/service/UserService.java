package com.kelvin.goodsagent.service;

import com.kelvin.goodsagent.entity.User;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 18:28
 * @description:
 */
public interface UserService {

    User findUserByName(String username);

    User saveUser(User user);


}
