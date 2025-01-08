package org.example.testsecurity.service;

import org.example.testsecurity.dto.CustomUserDetails;
import org.example.testsecurity.entity.UserEntity;
import org.example.testsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {


    //db 연결
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserEntity userData = userRepository.findByUsername(username);

        if (userData != null) {
            // alt + Enter => 호출 단축키
            return new CustomUserDetails(userData);

        }



        return null;
    }
}