package com.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class LogInRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Login getUserByUserNameInLogin(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), Login.class);
    }

    public User getUserByUserName(String userName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("userName").is(userName)), User.class);
    }
    public void loginApi(Login login) {
        mongoTemplate.save(login);

    }
}
