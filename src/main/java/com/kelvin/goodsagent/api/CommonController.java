package com.kelvin.goodsagent.api;

import com.kelvin.goodsagent.api.vo.AccountVo;
import com.kelvin.goodsagent.common.http.RestResult;
import com.kelvin.goodsagent.entity.Account;
import com.kelvin.goodsagent.entity.User;
import com.kelvin.goodsagent.service.AccountService;
import com.kelvin.goodsagent.service.AreaService;
import com.kelvin.goodsagent.seucurity.JwtUtil;
import com.kelvin.goodsagent.util.DozerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/15 12:57
 * @description:
 */
//@RestController
//@RequestMapping("api")
public class CommonController extends BaseController {


    //@Autowired
    //private AreaService areaService;



}
