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

//    public void enrollUser(User user) {
//       userEnrollRepository.enrollUser(user);
//    }
//
//    public List<User> viewoneuser(String userId) {
//        return userEnrollRepository.viewoneuser(userId);
//    }
//
//    public List viewParticularSmartMeterForAUser(String smartMeterId) {
//        return userEnrollRepository.viewParticularSmartMeterForAUser(smartMeterId);
//    }
//
//    public void updateProivder(String smartMeterId, String providerId, String userId) {
//        userEnrollRepository.updateProivder(smartMeterId,providerId,userId);
//    }
//
//    public void createUser(String userId) {
//        userEnrollRepository.createUser(userId);
//    }
//
//    public int countUser(String userId) {
//       return userEnrollRepository.getUserCount(userId);
//    }
}
