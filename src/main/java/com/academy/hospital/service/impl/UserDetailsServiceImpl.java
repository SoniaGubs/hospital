package com.academy.hospital.service.impl;

import com.academy.hospital.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user= userRepository.findByUsername(username);

        if(user==null || !user.isEnabled() || !user.isAccountNonLocked()){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

   public Integer findUserId (UserDetails userDetails){
        return userRepository.findByUsername(userDetails.getUsername()).getId();
    }

}
