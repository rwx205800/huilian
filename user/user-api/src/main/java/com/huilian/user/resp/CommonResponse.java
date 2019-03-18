package com.huilian.user.resp;

import java.io.Serializable;

/**
 * <p>Title: huilian</p>
 * <p>Description: </p>
 *
 * @author renfei
 * @date 2019/3/15
 */
public class CommonResponse<T> implements Serializable {

    private static final long serialVersionUID = -8125909785640543696L;

    public static final int SUCCESS_CODE = 0;
    public static final int FAIL_CODE = 500;

    private Integer code;
    private String message;
    private T data;

    public CommonResponse() {
    }

    public CommonResponse(int code) {
        this(code, null);
    }

    public CommonResponse(int code, T data) {
        this(code, "", data);
    }

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message == null ? "" : message;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(SUCCESS_CODE, data);
    }

    public static CommonResponse success() {
        return new CommonResponse(SUCCESS_CODE);
    }

    public static CommonResponse fail() {
        return new CommonResponse(FAIL_CODE);
    }

    public static CommonResponse fail(String detail) {
        return new CommonResponse(FAIL_CODE, detail,null);
    }

    public boolean isSuccess() {
        return this.code != null && this.code == CommonResponse.SUCCESS_CODE;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
