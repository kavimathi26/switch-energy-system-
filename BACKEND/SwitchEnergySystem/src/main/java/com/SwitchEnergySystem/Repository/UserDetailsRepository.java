package com.SwitchEnergySystem.Repository;


import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Pojo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDetailsRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public List<UserDetails> viewUserDetails(String userId) {
        UserDetails userDetails = new UserDetails();
//        Query query = new Query().addCriteria(Criteria.where("userId").is(userId));
//        User user = new User(userId);
//        user = mongoTemplate.find(query,User.class);
        System.out.println("heyyyyyyyy");
        mongoTemplate.save(userDetails);
        return null;
    }
}
