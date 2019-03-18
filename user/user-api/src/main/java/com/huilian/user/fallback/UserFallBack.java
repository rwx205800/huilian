package com.huilian.user.fallback;

import com.huilian.user.api.IUserApi;
import com.huilian.user.dto.UserInfo;
import com.huilian.user.resp.CommonResponse;
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
            public CommonResponse getUserInfo(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Long userId) {
                return new CommonResponse(500,"user service is not work",null);
            }

            @Override
            public CommonResponse save(@ApiParam(value = "用户信息", required = true) @RequestBody UserInfo userInfo) {
                System.out.println("user service is not work");
                return new CommonResponse(500,"save service is not work",null);
            }
        };
    }
}
