package com.example.demo.service;

import com.example.demo.vo.AuthUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println("Auth====================="+id);
        AuthUserVO user = this.getUser(id);
        List<GrantedAuthority> authorities = new Vector<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private AuthUserVO getUser(String id) {
        AuthUserVO user = new AuthUserVO();

        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("12345"));

        return user;
    }

}
