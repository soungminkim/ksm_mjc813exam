package com.mjc813.food_web.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface IMember extends UserDetails {
    Long getId();
    void setId(final Long Id);

    String getUsername();
    void setUsername(final String username);

    String getPassword();
    void setPassword(final String password);

    String getName();
    void setName(final String name);

    String getNickName();
    String getPhoneNumber();
    String getEmail();
    String getRole();

    void setNickName(final String nickName);
    void setPhoneNumber(final String phoneNumber);
    void setEmail(final String email);
    void setRole(final String role);

    default void copyMembers(IMember isrc) {
        if ( isrc == null ) {
            return;
        }
        this.setId(isrc.getId());
        this.setUsername(isrc.getUsername());
        this.setPassword(isrc.getPassword());
        this.setName(isrc.getName());
        this.setNickName(isrc.getNickName());
        this.setPhoneNumber(isrc.getPhoneNumber());
        this.setEmail(isrc.getEmail());
        this.setRole(isrc.getRole());
    }

    default void copyMembersNotNull(IMember isrc) {
        if ( isrc == null ) {
            return;
        }
        if (isrc.getId() != null) {
            this.setId(isrc.getId());
        }
        if (isrc.getUsername() != null) {
            this.setUsername(isrc.getUsername());
        }
        if (isrc.getPassword() != null) {
            this.setPassword(isrc.getPassword());
        }
        if (isrc.getName() != null) {
            this.setName(isrc.getName());
        }
        if (isrc.getNickName() != null) {
            this.setNickName(isrc.getNickName());
        }
        if (isrc.getPhoneNumber() != null) {
            this.setPhoneNumber(isrc.getPhoneNumber());
        }
        if (isrc.getEmail() != null) {
            this.setEmail(isrc.getEmail());
        }
        if (isrc.getRole() != null) {
            this.setRole(isrc.getRole());
        }
    }

    default Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        if ( this.getRole() != null ) {
            roles.add(new SimpleGrantedAuthority(this.getRole()));
        }
        return roles;
    }
}
