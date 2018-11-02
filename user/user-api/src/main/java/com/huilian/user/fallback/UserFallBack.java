package com.huilian.user.fallback;

import com.huilian.user.api.IUserApi;
import com.huilian.user.dto.UserInfo;
import feign.hystrix.FallbackFactory;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: huilian</p>
 * <p>Description: </p>
 *
 * @author renfei
 * @date 2018/11/2
 */
@Component
public class UserFallBack implements FallbackFactory<IUserApi> {

    @Override
    public IUserApi create(Throwable throwable) {
        return new IUserApi() {
            @Override
            public UserInfo getUserInfo(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Long userId) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId(1);
                userInfo.setName("rf");
                return userInfo;
            }

            @Override
            public String save(@ApiParam(value = "用户信息", required = true) @RequestBody UserInfo userInfo) {
                return "save service is not work";
            }
        };
    }
}
