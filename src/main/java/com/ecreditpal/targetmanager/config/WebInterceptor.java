package com.ecreditpal.targetmanager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengzhenwen
 * @data 2019/4/9 11:26
 * @description
 **/
@Slf4j
public class WebInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getRequestURL().toString());
        return super.preHandle(request, response, handler);
    }
}
