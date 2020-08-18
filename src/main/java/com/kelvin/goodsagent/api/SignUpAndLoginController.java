package com.kelvin.goodsagent.api;

import com.kelvin.goodsagent.common.http.RestResult;
import com.kelvin.goodsagent.dto.LoginDto;
import com.kelvin.goodsagent.dto.SignupDto;
import com.kelvin.goodsagent.entity.User;
import com.kelvin.goodsagent.enums.VipLvl;
import com.kelvin.goodsagent.service.UserService;
import com.kelvin.goodsagent.seucurity.JwtUtil;
import com.kelvin.goodsagent.seucurity.SecUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 21:37
 * @description: 注册登录接口
 */
@Tag(name = "注册登录接口")
@RestController
@Slf4j
public class SignUpAndLoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource(name = "myUserDetailService")
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @Operation(summary = "登录接口",description = "",responses = {})
    @PostMapping("login")
    public RestResult login(@RequestBody @Validated LoginDto loginDto) throws Exception {
        //try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword())
            );
        //}catch (BadCredentialsException e){
        //    //throw new Exception("Incorrect username or password",e);
        //    return RestResult.fail(403,"用户名或密码错误","Bad credentials");
        //}

        SecUserDetails userDetails = (SecUserDetails) userDetailsService.loadUserByUsername(loginDto.getUsername());
        //TODO:更新登录时间
        final String jwt = jwtUtil.generateToken(userDetails);
      return RestResult.success(jwt,"登录成功！");
    }


    @Operation(summary = "注册接口",description = "")
    @PostMapping("singup")
    public RestResult sigup(@Validated @RequestBody SignupDto sigupDto){
        User user = new User();
        user.setUsername(sigupDto.getUsername());
        user.setPassword(passwordEncoder.encode(sigupDto.getPassword()));
        user.setQq(sigupDto.getQq());
        user.setVipLvl(VipLvl.VIP1);
        user.setCreateTime(new Date());
        user.setRole("user");
        userService.saveUser(user);
        return RestResult.success();
    }

}
