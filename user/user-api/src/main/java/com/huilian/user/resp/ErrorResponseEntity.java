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
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ErrorResponseEntity(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}