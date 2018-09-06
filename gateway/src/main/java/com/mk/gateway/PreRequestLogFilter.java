package com.mk.gateway;


import com.huilian.user.api.IUserApi;
import com.huilian.user.dto.UserInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Component
public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);
    @Autowired
    private IUserApi userApi;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse rp = ctx.getResponse();
        RequestContext context = RequestContext.getCurrentContext();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            LOGGER.info(key + ":" + value);
        }

        UserInfo userInfo = userApi.getUserInfo(1l);//调用用户服务接口

        LOGGER.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getHeader("Authorization");

       /* if (!checkToken(token)){
            LOGGER.error("非法token",token);
            HttpServletResponse response = ctx.getResponse();
            response.setContentType("application/json");
            response.setStatus(21001);
            try {
                response.sendError(21001,  "请登录");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/




        return null;
    }

    private boolean checkToken(String token) {

        return false;

    }
}