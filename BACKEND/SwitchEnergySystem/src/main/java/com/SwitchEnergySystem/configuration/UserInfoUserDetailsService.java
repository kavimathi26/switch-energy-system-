package com.SwitchEnergySystem.configuration;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.LogInRepository;
import com.SwitchEnergySystem.Repository.UserEnrollRepository;
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
    private LogInRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Login> signUpOptional = Optional.ofNullable(repository.getUserByUserNameInLogin(userName));
        return signUpOptional.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + userName));

    }
}