package com.cfd.member.mapper;

import com.cfd.pojo.mo.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:45
 */
public interface CustomerRepository extends MongoRepository<Member,String> {

    Member findByUserName(String userName);

}
