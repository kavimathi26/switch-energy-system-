package com.SwitchEnergySystem.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.SwitchEnergySystem.Repository.UserEnrollRepository;
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

    public List<SmartMeter> enrollUser(User user) {
       return userEnrollRepository.enrollUser(user);
    }

    public List<User> viewoneuser(String userId) {
        return userEnrollRepository.viewoneuser(userId);
    }

    public List viewParticularSmartMeterForAUser(String smartMeterId) {
        return userEnrollRepository.viewParticularSmartMeterForAUser(smartMeterId);
    }
}
