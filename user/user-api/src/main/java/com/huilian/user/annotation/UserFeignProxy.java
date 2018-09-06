package com.huilian.user.annotation;

import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.huilian.user.api"})
public class UserFeignProxy {
    public UserFeignProxy() {

    }
}
