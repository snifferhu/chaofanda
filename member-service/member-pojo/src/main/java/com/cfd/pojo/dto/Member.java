package com.cfd.pojo.dto;

import com.cfd.pojo.vo.RegisterVo;
import com.google.common.collect.ImmutableList;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:46
 */
public class Member {
    @Id
    private String id;

    private String userName;

    private String password;

    private String nickName;

    private List<String> authorities;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Member() {
    }

    public Member(String id, String userName, String password, String nickName, List<String> authorities, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.authorities = authorities;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Member(Member other) {
        this.id = other.id;
        this.userName = other.userName;
        this.password = other.password;
        this.nickName = other.nickName;
        this.authorities = other.authorities;
        this.status = other.status;
        this.createTime = other.createTime;
        this.updateTime = other.updateTime;
    }

    public static Member createUserByRegisterVo(RegisterVo vo) {
        Member member = createUserByUserName(vo.getUserName());
        member.setNickName(vo.getNickName());
        member.setPassword(vo.getPassword());
        return member;
    }

    public static Member createUserByUserName(String name){
        Member member = new Member();
        member.setUserName(name);
        member.setAuthorities(ImmutableList.of("user"));
        return member;
    }

    public static Member createManagerByUserName(String name){
        Member member = new Member();
        member.setUserName(name);
        member.setAuthorities(ImmutableList.of("manager"));
        return member;
    }

    public String getNickName() {
        return nickName;
    }

    public Member setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public Member setAuthorities(List<String> authorities) {
        this.authorities = authorities;
        return this;
    }

    public String getId() {
        return id;
    }

    public Member setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Member setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Member setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Member setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Member setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Member setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id='").append(id).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append('}');
        return sb.toString();
    }
}
