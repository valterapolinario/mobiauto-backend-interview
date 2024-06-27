package com.br.mobiauto.management.service.impl;

import com.br.mobiauto.management.exception.GeneralNotFoundException;
import com.br.mobiauto.management.model.UserDB;
import com.br.mobiauto.management.model.UserPositionEnum;
import com.br.mobiauto.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDB userDB = userRepository.findByEmail(email).orElseThrow(() -> new GeneralNotFoundException("E-mail nao cadastrado :", email));
        return User.builder()
                .username(userDB.getEmail())
                .password(userDB.getPassword())
                .authorities(getAuthorities(userDB.getPosition()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserPositionEnum roles) {

        return Arrays
                .stream(UserPositionEnum.values())
                .map(UserPositionEnum::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
