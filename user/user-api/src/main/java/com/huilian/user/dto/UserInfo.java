package com.huilian.user.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1301229931511651654L;

    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    @ApiModelProperty("姓名")
    @NotBlank(message = "姓名不能为空")
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
