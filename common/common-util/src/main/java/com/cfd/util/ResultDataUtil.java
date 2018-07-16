package com.cfd.util;

import com.cfd.context.ResultCode;
import com.cfd.pojo.vo.ResultData;

/**
 * @auth snifferhu
 * @date 2018/7/16 23:05
 */
public class ResultDataUtil {

    private static final ResultData SUCCESS = new ResultData<String>().setCode(ResultCode.SUCCESS.getCode()).setMessage(ResultCode.SUCCESS.getMessage());
    private static final ResultData FAIL = new ResultData<String>().setCode(ResultCode.FAIL.getCode()).setMessage(ResultCode.FAIL.getMessage());

    public static ResultData success() {
        return SUCCESS;
    }

    public static ResultData success(String ok) {
        return new ResultData<String>().setCode(ResultCode.SUCCESS.getCode()).setMessage(ok);
    }

    public static <T> ResultData success(T body) {
        return new ResultData<T>()
                .setCode(ResultCode.SUCCESS.getCode())
                .setMessage(ResultCode.SUCCESS.getMessage())
                .setBody(body);
    }

    public static ResultData fail() {
        return FAIL;
    }

    public static ResultData fail(String msg) {
        return new ResultData<String>().setCode(ResultCode.FAIL.getCode()).setMessage(msg);
    }

    public static ResultData fail(ResultCode body) {
        return new ResultData()
                .setCode(body.getCode())
                .setMessage(body.getMessage());
    }

    public static <T> ResultData fail(T body) {
        return new ResultData<T>()
                .setCode(ResultCode.FAIL.getCode())
                .setMessage(ResultCode.FAIL.getMessage())
                .setBody(body);
    }

    public static ResultData paramsFail(String paramsName) {
        return new ResultData()
                .setCode(ResultCode.PARAMS_FAIL.getCode())
                .setMessage(paramsName + ResultCode.PARAMS_FAIL.getMessage());
    }

    public static ResultData statusFail(String statusName) {
        return new ResultData()
                .setCode(ResultCode.STATUS_FAIL.getCode())
                .setMessage(statusName + ResultCode.STATUS_FAIL.getMessage());
    }
}
