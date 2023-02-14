package com.SwitchEnergySystem.Repository;

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

    public void enrollUser(User user) {
        mongoTemplate.save(user);
        System.out.println("id "+user.getSmartMeterId());
        smartMeterEnrollRepository.setSmartMeter(user.getSmartMeterId());
    }

    public List<User> viewoneuser(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        System.out.println(mongoTemplate.find(query,User.class));
        return mongoTemplate.find(query,User.class);
    }
    public List viewParticularSmartMeterForAUser(String smartMeterId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        System.out.println(mongoTemplate.find(query,SmartMeter.class));
        return mongoTemplate.find(query,SmartMeter.class);
    }
}
