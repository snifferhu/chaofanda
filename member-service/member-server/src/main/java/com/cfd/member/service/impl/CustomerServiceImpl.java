package com.cfd.member.service.impl;

import com.cfd.member.mapper.CustomerRepository;
import com.cfd.member.service.CustomerService;
import com.cfd.pojo.mo.Customer;
import com.mongodb.client.result.UpdateResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @auth snifferhu
 * @date 2018/7/15 15:10
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public List<Customer> queryAllByUserName(String name) {
        return customerRepository.findAll(Example.of(Customer.createByUserName(name)));
    }


    @Override
    public Customer queryByUserName(String name) {
        return customerRepository.findByUserName(name);
    }

    @Override
    public Optional<Customer> queryById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public long disableByUserName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(name));

        Update update = new Update();
        update.set("status", 1);
        update.set("updateTime",new Date());
        UpdateResult result = mongoOperation.updateFirst(query, update, Customer.class);
        return result.getModifiedCount();
    }

    @Override
    public boolean existsById(String id){
        return customerRepository.existsById(id);
    }

    @Override
    public boolean existsByUserName(String name){
        return customerRepository.exists(Example.of(Customer.createByUserName(name)));
    }

    @Override
    public void enableById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customer.ifPresent(customer1 -> {
            customer1.setStatus(0);
            customer1.setUpdateTime(new Date());
            customerRepository.save(customer1);
        });
    }

    @Override
    public void enableByUserName(String name) {
        List<Customer> customerList = queryAllByUserName(name);
        if (customerList != null && customerList.size() != 0){
            customerList.get(0).setStatus(0);
            customerList.get(0).setUpdateTime(new Date());
            customerRepository.save(customerList.get(0));
        }
    }

    @Override
    public Customer insert(Customer customer) {
        if (!existsByUserName(customer.getUserName())) {
            customer.setCreateTime(new Date());
            customer.setUpdateTime(new Date());
            customer.setStatus(0);
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            return customerRepository.insert(customer);
        }
        return customer;
    }
}
