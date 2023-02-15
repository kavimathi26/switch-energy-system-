package com.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Pojo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
//        UserDetails userDetails = new UserDetails();
//        userDetails.setUserId(user.getUserId());
//        userDetails.setSmartMeterId(user.getSmartMeterId());
//        userDetails.setEnergyProvider(user.getProviderId());
//        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(user.getSmartMeterId()));
//        System.out.println(query);
//        mongoTemplate.save(userDetails);
//        userDetails.setTotalReadings();
        mongoTemplate.save(user);
//        System.out.println("id "+user.getSmartMeterId());
//        smartMeterEnrollRepository.setSmartMeter(user.getSmartMeterId());
    }

    public List<User> viewoneuser(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
//        System.out.println(mongoTemplate.find(query,User.class));
        return mongoTemplate.find(query,User.class);
    }
    public List viewParticularSmartMeterForAUser(String smartMeterId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        System.out.println(mongoTemplate.find(query,SmartMeter.class));
        return mongoTemplate.find(query,SmartMeter.class);
    }

    public void updateProivder(String smartMeterId, String providerId, String userId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        Update update = new Update();
        update.set("providerId",providerId);
        mongoTemplate.findAndModify(query,update, SmartMeter.class);
        Query query1 = new Query().addCriteria(Criteria.where("userId").is(userId));
        update.set("providerId",providerId);
        mongoTemplate.findAndModify(query,update, User.class);
        }

        public void createUser(String userId) {
            User user = new User(userId);
            mongoTemplate.save(user);
//            smartMeterEnrollRepository.setSmartMeter(user.getSmartMeterId());
        }
        public int getUserCount(String userId) {
            Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
            System.out.println(mongoTemplate.find(query,User.class).size());
       return mongoTemplate.find(query,User.class).size();
    }
}
