package com.huilian.user.resp;

/**
 * <p>Title: huilian</p>
 * <p>Description: </p>
 *
 * @author renfei
 * @date 2019/3/15
 */
public class ErrorResponseEntity {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
