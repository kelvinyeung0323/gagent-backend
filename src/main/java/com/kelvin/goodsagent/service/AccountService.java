package com.kelvin.goodsagent.service;

import com.kelvin.goodsagent.dto.AccountFlowQueryDto;
import com.kelvin.goodsagent.entity.Account;
import com.kelvin.goodsagent.entity.AccountFlow;
import org.springframework.data.domain.Page;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:54
 * @description:
 */
public interface AccountService {

    Page<AccountFlow> queryAccountFlow(AccountFlowQueryDto query);
    Account getAccountByUserId(String userId);
}
