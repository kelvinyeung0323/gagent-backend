package com.kelvin.goodsagent.api;

import com.kelvin.goodsagent.api.vo.AccountFlowVo;
import com.kelvin.goodsagent.api.vo.AccountVo;
import com.kelvin.goodsagent.common.http.RestResult;
import com.kelvin.goodsagent.dto.AccountFlowQueryDto;
import com.kelvin.goodsagent.entity.Account;
import com.kelvin.goodsagent.entity.AccountFlow;
import com.kelvin.goodsagent.service.AccountService;
import com.kelvin.goodsagent.seucurity.JwtUtil;
import com.kelvin.goodsagent.util.DozerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 15:20
 * @description:
 */
@RestController
@RequestMapping("api")
public class AccountController extends BaseController {


    @Autowired
    private AccountService accountService;
    @GetMapping("acountflow")
    public RestResult<List<AccountFlowVo>> getAccountFlow(@RequestBody AccountFlowQueryDto queryDto){
        Page<AccountFlow> page= accountService.queryAccountFlow(queryDto);
        return  RestResult.page(page,AccountFlowVo.class);
    }

    @GetMapping("account")
    public RestResult<AccountVo> getAccount(Authentication auth){
        Account account = accountService.getAccountByUserId(getCurrentUser().getId());
        AccountVo accountVo = DozerUtil.map(account,AccountVo.class);
        return RestResult.success(accountVo);
    }

}
