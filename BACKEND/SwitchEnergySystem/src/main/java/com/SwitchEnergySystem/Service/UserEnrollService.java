package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.UserEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEnrollService {
    @Autowired
    UserEnrollRepository userEnrollRepository;
    public List viewAllUsers() {
       return userEnrollRepository.viewAllUsers();
    }


    public void enrollUser(User user) {
        userEnrollRepository.enrollUser(user);
    }
}
