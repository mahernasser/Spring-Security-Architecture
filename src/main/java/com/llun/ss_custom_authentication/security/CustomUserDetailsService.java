package com.llun.ss_custom_authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public CustomUserDetailsService() {
        this.inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        var u = User.withUsername("maher")
                .password(passwordEncoder().encode("maher"))
                .authorities( "read")

                .build();
        var m = User.withUsername("ahmed")
                .password(passwordEncoder().encode("ahmed"))
                .authorities("write", "read")
                .build();
        this.inMemoryUserDetailsManager.createUser(u);
        this.inMemoryUserDetailsManager.createUser(m);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.inMemoryUserDetailsManager.loadUserByUsername(username);
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}