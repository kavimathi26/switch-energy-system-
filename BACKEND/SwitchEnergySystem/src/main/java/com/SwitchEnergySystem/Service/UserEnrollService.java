package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.UserEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEnrollService {
    @Autowired
    UserEnrollRepository userEnrollRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public List viewAllUsers() {
       return userEnrollRepository.viewAllUsers();
    }


    public void enrollUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userEnrollRepository.enrollUser(user);
    }


    public String findRole(String userName) {
        return userEnrollRepository.findRole(userName);
    }
}
