package com.huilian.user.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * @author admin
 */
public class FeignRequestInterceptor implements RequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Map<String, Collection<String>> headers = requestTemplate.headers();
        String body = requestTemplate.body() == null ? null : new String(requestTemplate.body());
        Map<String, Collection<String>> queries = requestTemplate.queries();
        String url = requestTemplate.request().url();
        String method = requestTemplate.method();
        logger.info("Feign请求: url:{},method:{},headers:{},body:{},params:{}", url, method, headers, body, queries);
    }
}
