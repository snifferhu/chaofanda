package com.cfd.member.service;

import com.cfd.pojo.mo.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:44
 */
public interface CustomerService {

    List<Customer> queryAllByUserName(String name);

    Customer queryByUserName(String name);

    Optional<Customer> queryById(String id);

    void deleteById(String id);

    long disableByUserName(String name);

    boolean existsById(String id);

    boolean existsByUserName(String name);

    void enableById(String id);

    void enableByUserName(String name);

    Customer insert(Customer customer);
}
