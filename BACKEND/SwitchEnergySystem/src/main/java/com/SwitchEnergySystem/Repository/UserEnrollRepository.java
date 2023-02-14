package com.SwitchEnergySystem.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.User;
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

    public List<SmartMeter> enrollUser(User user) {
        String smartMeterId = (String) user.getSmartMeterId();
        System.out.println("smartMeterId "+smartMeterId);
//        System.out.println(smartMeterId.getClass().getName());
        smartMeterEnrollRepository.setSmartMeter(smartMeterId);
        smartMeterEnrollRepository.getSmartMeter(smartMeterId);
        mongoTemplate.save(user);
        return smartMeterEnrollRepository.getSmartMeter(smartMeterId);
    }

    public List<User> viewoneuser(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
        System.out.println(mongoTemplate.find(query,User.class));
        return mongoTemplate.find(query,User.class);
    }
    public List viewParticularSmartMeterForAUser(String id) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(id));
        System.out.println(mongoTemplate.find(query,SmartMeter.class));
        return mongoTemplate.find(query,SmartMeter.class);
    }
}
