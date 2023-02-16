package com.SwitchEnergySystem.configuration;

import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.UserEnrollRepository;
//import com.instagram.instaModule.model.SignUp;
//import com.instagram.instaModule.model.Users;
//import com.instagram.instaModule.repository.SignUpRepository;
//import com.instagram.instaModule.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserEnrollRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> signUpOptional = Optional.ofNullable(repository.getUserByUserIdInLogin(userName));
        return signUpOptional.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + userName));

    }
}