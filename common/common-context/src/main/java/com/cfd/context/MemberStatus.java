package com.cfd.context;

/**
 * @auth snifferhu
 * @date 2018/7/16 23:27
 */
public enum MemberStatus {
    ENABLE(0, "enable"),
    DISABLE(1, "disable");

    private Integer code;
    private String message;

    MemberStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(String msg) {
        msg = msg.trim();
        for (MemberStatus status:MemberStatus.values()){
            if (status.getMessage().equals(msg)){
                return status.getCode();
            }
        }
        return -1;
    }

    public MemberStatus setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MemberStatus setMessage(String message) {
        this.message = message;
        return this;
    }
}
