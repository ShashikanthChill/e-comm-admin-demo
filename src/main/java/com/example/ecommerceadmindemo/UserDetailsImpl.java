/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerceadmindemo;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author The_Humble_Fool
 */
public class UserDetailsImpl implements UserDetails {

    private UserPersistenceEntityModel userEntityModel;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(UserPersistenceEntityModel userEntityModel) {
        this.userEntityModel = userEntityModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return Arrays.asList(new GrantedAuthority[]{authority});
    }

    @Override
    public String getPassword() {
        return userEntityModel.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntityModel.getUsername();
    }

    public int getUserId() {
        return userEntityModel.getId();
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

}
