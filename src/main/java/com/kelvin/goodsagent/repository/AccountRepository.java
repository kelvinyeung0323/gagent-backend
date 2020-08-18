package com.kelvin.goodsagent.repository;

import com.kelvin.goodsagent.entity.Account;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:49
 * @description:
 */
public interface AccountRepository extends BaseRepository<Account,String> {

    Account findByUserId(String userId);
}
