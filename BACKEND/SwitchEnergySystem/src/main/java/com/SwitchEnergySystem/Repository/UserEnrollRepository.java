package com.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public User getUserByUserNameInLogin(String userName) {
        Query query = new Query().addCriteria(Criteria.where("userName").is(userName));
        return mongoTemplate.findOne(query, User.class);
    }
    public void enrollUser(User user) {
        if(user.getRole().equals("USER")) {
            smartMeterEnrollRepository.enrollUserSettings(user.getUserName());
        }
        mongoTemplate.save(user);
    }


}
