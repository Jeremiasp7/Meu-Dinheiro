package com.example.meudinheiro.modules.user.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.meudinheiro.modules.user.entities.UserEntity;
import com.example.meudinheiro.modules.user.repositories.UserRepository;

@Service
public class UserDetailsUseCaseImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserEntity user = userRepository.findByEmail(username).get();

        return UserDetailsImpl.build(user);
    }
    
}
