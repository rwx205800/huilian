package com.huilian.user.dto;

import io.swagger.annotations.ApiModelProperty;

public class UserInfo {
    @ApiModelProperty("用户ID")
    private long userId;
    @ApiModelProperty("姓名")
    private String name;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
