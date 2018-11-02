package com.huilian.user.api;

import com.huilian.user.dto.UserInfo;
import com.huilian.user.fallback.UserFallBack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user",fallback = UserFallBack.class)
@Api(value = "/UserApi", tags = "UserAPI", description = "用户模块")
@RequestMapping("v1")
public interface IUserApi {
    @RequestMapping(value = "/user/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取用户信息", httpMethod = "GET", tags = "UserAPI",response= UserInfo.class)
    UserInfo getUserInfo(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Long userId);

    @RequestMapping(value = "/user/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "保存", httpMethod = "POST", tags = "UserAPI", response = String.class)
    String save(@ApiParam(value = "用户信息", required = true) @RequestBody UserInfo userInfo);

}
