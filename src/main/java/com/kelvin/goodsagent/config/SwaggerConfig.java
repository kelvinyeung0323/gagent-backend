package com.kelvin.goodsagent.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/10 13:02
 * @description: 使用swagger3
 */
@Configuration
//@OpenAPIDefinition(
//        info = @Info(
//                title = "标题",
//                version = "1.0",
//                description = "描述信息"
//        ),
//        externalDocs = @ExternalDocumentation(description = "参考文档",
//                url = "https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations"
//        )
//)
public class SwaggerConfig {

    @Value("${appVersion:v1.0}")
    private String appVersion;

    /**
     *
     * 参考：https://swagger.io/docs/open-source-tools/swagger-ui/usage/configuration/
     *     https://springdoc.org/faq.html#how-do-i-add-authorization-header-in-requests
     * @return
     */
    @Bean
    public OpenAPI createOpenAPI(){
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
                        //.addParameters("Authorization", new Parameter().in("header").schema(new StringSchema()).name("Authorization"))
                        //.addHeaders("Authorization", new Header().description("JWT Bearer token").schema(new StringSchema()))

                )
                .info(new Info().title("eshop接口文档").version(appVersion)
                .description("")
                .termsOfService("http://www.yeungstech.com")
                .license(new License().name("Apache 2.0").url("http://www.yeungstech.com")));
    }


    /** swagger -> OpenAPI 对应注解
     * @ApiParam -> @Parameter
     * @ApiOperation -> @Operation
     * @Api -> @Tag
     * @ApiImplicitParams -> @Parameters
     * @ApiImplicitParam -> @Parameter
     * @ApiIgnore -> @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden
     * @ApiModel -> @Schema
     * @ApiModelProperty -> @Schema
     *
     *
     */

}
