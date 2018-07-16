package com.cfd.member.mapper;

import com.cfd.pojo.mo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:45
 */
public interface CustomerRepository extends MongoRepository<Customer,String> {

    Customer findByUserName(String userName);

}
