package com.cfd.member.service;

import com.cfd.pojo.dto.Member;

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

    long enableByUserName(String name);

    Member register(Member member);

    long updateStatusById(String id, Integer targetStatus);

    long updateStatusByName(String name, Integer targetStatus);

    void deleteByUserName(String s);
}
