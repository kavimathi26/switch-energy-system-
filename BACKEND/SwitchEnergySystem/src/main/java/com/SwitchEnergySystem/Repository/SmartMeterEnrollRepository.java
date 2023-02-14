package com.SwitchEnergySystem.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.SmartMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


@Repository
public class SmartMeterEnrollRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void setSmartMeter(String smartMeterId) {
        SmartMeter smartMeter = new SmartMeter();
        smartMeter.setSmartMeterId(smartMeterId);
        System.out.println("setSmartMeter");
        mongoTemplate.save(smartMeter);
    }
    public List getSmartMeter(String smartMeterId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        System.out.println("getSmartMeter");
        return mongoTemplate.find(query,SmartMeter.class);
    }
//    public void enrollSmartMeter(SmartMeter smartMeter) {
//        mongoTemplate.save(smartMeter);
//    }

    public SmartMeter approvalstatus(String approvalStatus,String smartMeterId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        Update update = new Update();
        update.set("approvalStatus",approvalStatus);
        System.out.println(update);
        return mongoTemplate.findAndModify(query,update,SmartMeter.class);

    }
    public List viewListOfSmartMetersForAParticularProviderId(String providerId) {
        Query query = new Query().addCriteria(Criteria.where("providerId").is(providerId));
        return mongoTemplate.find(query,SmartMeter.class);
    }
}
