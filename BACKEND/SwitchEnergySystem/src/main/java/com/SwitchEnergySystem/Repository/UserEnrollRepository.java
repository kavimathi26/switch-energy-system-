package com.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserEnrollRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    SmartMeterEnrollRepository smartMeterEnrollRepository;
    public List viewAllUsers() {
        return mongoTemplate.findAll(User.class);
    }
    public void enrollUser(User user) {
        if(user.getRole().equals("User")) {
            smartMeterEnrollRepository.enrollUserSettings(user.getUserId());
        }
        mongoTemplate.save(user);
    }

}
