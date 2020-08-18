package com.kelvin.goodsagent.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 21:42
 * @description:
 */
@Schema(description = "登录信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @Schema(description = "用户名称")
    @NotBlank
    private String username;

    @Schema(description = "密码")
    private String password;
}
