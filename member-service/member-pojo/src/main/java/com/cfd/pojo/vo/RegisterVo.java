package com.cfd.pojo.vo;

/**
 * @auth snifferhu
 * @date 2018/7/16 22:43
 */
public class RegisterVo {
    private String userName;
    private String password;
    private String nickName;

    public RegisterVo() {
    }

    public RegisterVo(String userName, String password, String nickName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public RegisterVo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterVo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public RegisterVo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterVo{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
