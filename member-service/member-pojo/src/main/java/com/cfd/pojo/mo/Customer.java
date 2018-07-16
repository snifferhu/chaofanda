package com.cfd.pojo.mo;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:46
 */
public class Customer {
    @Id
    private String id;

    private String userName;

    private String password;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Customer() {
    }

    public Customer(String id, String userName, String password, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Customer(Customer other) {
        this.id = other.id;
        this.userName = other.userName;
        this.password = other.password;
        this.status = other.status;
        this.createTime = other.createTime;
        this.updateTime = other.updateTime;
    }

    public static Customer createByUserName(String name){
        Customer customer = new Customer();
        customer.setUserName(name);
        return customer;
    }

    public String getId() {
        return id;
    }

    public Customer setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Customer setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Customer setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Customer setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Customer setUpdateTime(Date updateTime) {
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
