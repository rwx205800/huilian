package com.huilian.user.controller;

import com.huilian.user.annotation.CacheLock;
import com.huilian.user.annotation.CacheParam;
import com.huilian.user.api.IUserApi;
import com.huilian.user.dto.UserInfo;
import com.huilian.user.resp.CommonResponse;
import com.huilian.user.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController implements IUserApi {

    @Autowired
    private UserService userService;

    @Override
    public CommonResponse getUserInfo(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Long userId) {
        return userService.getUserInfo(userId);
    }

    @Override
    public CommonResponse save(@ApiParam(value = "用户信息", required = true)@Valid @RequestBody UserInfo userInfo) {
        return userService.save(userInfo);
    }

    @CacheLock(prefix = "books")
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token) {
        return "success - " + token;
    }

}
