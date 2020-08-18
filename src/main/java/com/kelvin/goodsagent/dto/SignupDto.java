package com.kelvin.goodsagent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/10 11:07
 * @description:
 */
@Schema(description = "注册信息")
@Data
public class SignupDto {



    @Schema(description = "用户名称")
    @NotBlank
    @Pattern(regexp = "^[a-z|A-Z]\\w{5,15}",message = "名称为以字母开头，可以包含大小写字线、数字、下划线，长度大于6位的字符串")
    private String username;

    @Schema(description = "密码")
    @NotBlank
    @Pattern(regexp = "\\w{6,}",message = "密码为6位有效字符")
    private String password;

    @Schema(description = "qq")
    private String qq;


}
