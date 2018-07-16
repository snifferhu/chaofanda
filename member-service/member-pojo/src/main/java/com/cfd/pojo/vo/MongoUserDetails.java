package com.cfd.pojo.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @auth snifferhu
 * @date 2018/7/16 20:52
 */
public class MongoUserDetails implements UserDetails {
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private Boolean accountNonExpired;
    private List<GrantedAuthority> grantedAuthorities;

    public MongoUserDetails() {
    }

    public MongoUserDetails(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public MongoUserDetails setUsername(String username) {
        this.username = username;
        return this;
    }

    public MongoUserDetails setPassword(String password) {
        this.password = password;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public MongoUserDetails setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public MongoUserDetails setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
        return this;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public MongoUserDetails setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
        return this;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public MongoUserDetails setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
        return this;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public MongoUserDetails setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
        return this;
    }
}
