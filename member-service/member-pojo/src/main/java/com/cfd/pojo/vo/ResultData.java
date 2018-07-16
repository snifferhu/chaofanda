package com.cfd.pojo.vo;

import com.cfd.context.ResultCode;

/**
 * @auth snifferhu
 * @date 2018/7/16 22:47
 */
public class ResultData<T> {
    private String message;
    private Integer code;
    private T body;

    public ResultData() {
    }

    public ResultData(String message, Integer code, T body) {
        this.message = message;
        this.code = code;
        this.body = body;
    }

    public ResultData(ResultData other) {
        this.message = other.message;
        this.code = other.code;
    }

    public String getMessage() {
        return message;
    }

    public ResultData setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public ResultData setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getBody() {
        return body;
    }

    public ResultData setBody(T body) {
        this.body = body;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResultData{");
        sb.append("message='").append(message).append('\'');
        sb.append(", code=").append(code);
        sb.append(", body=").append(body);
        sb.append('}');
        return sb.toString();
    }

    public ResultData success() {
        return new ResultData<String>().setCode(ResultCode.SUCCESS.getCode()).setMessage(ResultCode.SUCCESS.getMessage());
    }

    public ResultData success(String ok) {
        return new ResultData<String>().setCode(ResultCode.SUCCESS.getCode()).setMessage(ok);
    }

    public <T> ResultData success(T body) {
        return new ResultData<T>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(ResultCode.SUCCESS.getMessage())
                .setBody(body);
    }

    public ResultData fail() {
        return new ResultData<String>().setCode(ResultCode.FAIL.getCode()).setMessage(ResultCode.FAIL.getMessage());
    }

    public ResultData fail(String msg) {
        return new ResultData<String>().setCode(ResultCode.FAIL.getCode()).setMessage(msg);
    }

    public <T> ResultData fail(T body) {
        return new ResultData<T>()
                .setCode(ResultCode.FAIL.getCode())
                .setMessage(ResultCode.FAIL.getMessage())
                .setBody(body);
    }
}
