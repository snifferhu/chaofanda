package com.cfd.context;

/**
 * 10000:成功
 * 20000:入参校验失败,开发阶段
 * 30000:逻辑校验失败,运行阶段
 * 40000:默认异常失败
 * @auth snifferhu
 * @date 2018/7/16 22:55
 */
public enum ResultCode {
    SUCCESS(10000,"success"),
    PARAMS_FAIL(20000," Miss Params"),
    STATUS_FAIL(20001," Status IllegalArgument"),
    FAIL(40000,"error fail");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ResultCode setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultCode setMessage(String message) {
        this.message = message;
        return this;
    }
}
