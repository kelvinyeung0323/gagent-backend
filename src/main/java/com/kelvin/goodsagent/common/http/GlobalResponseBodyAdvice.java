package com.kelvin.goodsagent.common.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Date;

/**
 * @author: Kelvin Yeuung
 * @createdAt: 2020/8/9 23:43
 * @description:
 */
@ControllerAdvice(basePackages = "com.kelvin")
@Slf4j
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if(o instanceof RestResult){
            RestResult  result =(RestResult) o;
            String path = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getServletPath();
            result.setTimestamp(new Date());
            result.setPath(path);
        }

        return o;
    }
}
