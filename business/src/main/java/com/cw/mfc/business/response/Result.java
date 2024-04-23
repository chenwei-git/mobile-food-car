package com.cw.mfc.business.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> ok() {
        Result<T> result = new Result<T>();
        result.code = ResultCode.SUCCESS;
        result.message = "成功";
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<T>();
        result.code = ResultCode.SUCCESS;
        result.message = "成功";
        result.data = data;
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<T>();
        result.code = ResultCode.FAILURE;
        result.message = "系统异常，请联系管理员";
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<T>();
        result.code = ResultCode.FAILURE;
        result.message = message;
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<T>();
        result.code = code;
        result.message = message;
        return result;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }
}
