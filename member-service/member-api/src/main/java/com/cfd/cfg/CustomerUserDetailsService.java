package com.cfd.cfg;

import com.cfd.member.service.impl.MemberServiceImpl;
import com.cfd.pojo.mo.Member;
import com.cfd.pojo.mo.MongoUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户资源配置,提供security验证支持
 * @auth snifferhu
 * @date 2018/7/16 21:22
 */
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberServiceImpl customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = customerService.queryByUserName(username);
        return new MongoUserDetails(member.getUserName(), member.getPassword(), member.getAuthorities().toArray(new String[member.getAuthorities().size()]));
    }
}
