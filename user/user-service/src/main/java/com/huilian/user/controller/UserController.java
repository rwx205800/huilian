package com.huilian.user.controller;

import com.huilian.user.api.IUserApi;
import com.huilian.user.dto.UserInfo;
import com.huilian.user.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements IUserApi {

    @Autowired
    private UserService userService;

    @Override
    public UserInfo getUserInfo(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Long userId) {
        return userService.getUserInfo(userId);
    }

    @Override
    public String save(@ApiParam(value = "用户信息", required = true) @RequestBody UserInfo userInfo) {
        return userService.save(userInfo);
    }
}
