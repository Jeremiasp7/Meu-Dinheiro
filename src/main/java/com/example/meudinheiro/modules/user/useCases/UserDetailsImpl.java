package com.example.meudinheiro.modules.user.useCases;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.meudinheiro.modules.user.entities.UserEntity;

public class UserDetailsImpl implements UserDetails {

    private String email;
    private String password;

    public UserDetailsImpl(String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UserEntity user) {
        
        return new UserDetailsImpl(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }
    
}
