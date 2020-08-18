package com.kelvin.goodsagent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/16 13:43
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("OPTIONS","GET","POST","DELETE","PUT")
                .allowedOrigins("http://localhost:8080")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
}
