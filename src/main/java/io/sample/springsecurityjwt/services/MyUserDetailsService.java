package io.sample.springsecurityjwt.services;

import io.sample.springsecurityjwt.models.JwtUser;
import io.sample.springsecurityjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<JwtUser> jwtUser = userRepository.findByUsername(userName);
        if (jwtUser.isPresent()) {
            return new User(jwtUser.get().getUsername(), jwtUser.get().getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("Invalid User");
    }
}
