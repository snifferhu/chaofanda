package com.cfd.member.service;

import com.cfd.pojo.mo.Member;

import java.util.List;
import java.util.Optional;

/**
 * @auth snifferhu
 * @date 2018/7/15 13:44
 */
public interface MemberService {

    List<Member> queryAllByUserName(String name);

    Member queryByUserName(String name);

    Optional<Member> queryById(String id);

    void deleteById(String id);

    long disableByUserName(String name);

    boolean existsById(String id);

    boolean existsByUserName(String name);

    void enableById(String id);

    void enableByUserName(String name);

    Member insert(Member member);
}
