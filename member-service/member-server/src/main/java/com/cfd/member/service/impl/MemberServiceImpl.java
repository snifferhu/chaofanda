package com.cfd.member.service.impl;

import com.cfd.member.mapper.CustomerRepository;
import com.cfd.member.service.MemberService;
import com.cfd.pojo.mo.Member;
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
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @auth snifferhu
 * @date 2018/7/15 15:10
 */
@Service
public class MemberServiceImpl implements MemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MongoOperations mongoOperation;

    @Override
    public List<Member> queryAllByUserName(String name) {
        return customerRepository.findAll(Example.of(Member.createUserByUserName(name)));
    }


    @Override
    public Member queryByUserName(String name) {
        return customerRepository.findByUserName(name);
    }

    @Override
    public Optional<Member> queryById(String id) {
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
        UpdateResult result = mongoOperation.updateFirst(query, update, Member.class);
        return result.getModifiedCount();
    }

    @Override
    public boolean existsById(String id){
        return customerRepository.existsById(id);
    }

    @Override
    public boolean existsByUserName(String name){
        return customerRepository.exists(Example.of(Member.createUserByUserName(name)));
    }

    @Override
    public void enableById(String id) {
        Optional<Member> customer = customerRepository.findById(id);
        customer.ifPresent(customer1 -> {
            customer1.setStatus(0);
            customer1.setUpdateTime(new Date());
            customerRepository.save(customer1);
        });
    }

    @Override
    public void enableByUserName(String name) {
        List<Member> memberList = queryAllByUserName(name);
        if (memberList != null && memberList.size() != 0){
            memberList.get(0).setStatus(0);
            memberList.get(0).setUpdateTime(new Date());
            customerRepository.save(memberList.get(0));
        }
    }

    @Override
    public Member insert(Member member) {
        if (!existsByUserName(member.getUserName())) {
            member.setCreateTime(new Date());
            member.setUpdateTime(new Date());
            member.setStatus(0);
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            return customerRepository.insert(member);
        }
        return member;
    }
}
