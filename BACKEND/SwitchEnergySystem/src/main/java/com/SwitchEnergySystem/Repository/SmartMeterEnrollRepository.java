package com.SwitchEnergySystem.Repository;


import com.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.Pojo.SmartMeter;
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

    public List getSmartMeter(String smartMeterId) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        System.out.println("getSmartMeter");
        return mongoTemplate.find(query,SmartMeter.class);
    }
    public void updateSmartMeterCountForAProviderId(String providerId) {
        Query query = new Query().addCriteria(Criteria.where("providerId").is(providerId));
        Update update = new Update();
        update.set("countOfSmartMeters",viewListOfSmartMetersForAParticularProviderId(providerId).size());
        mongoTemplate.findAndModify(query,update, Provider.class);
    }
    public void enrollSmartMeter(SmartMeter smartMeter) {
        mongoTemplate.save(smartMeter);
        System.out.println(smartMeter.getProviderId());
        updateSmartMeterCountForAProviderId(smartMeter.getProviderId());
    }

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

    public List getUserWithSmartMeters(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId).and("approvalStatus").is("accepted"));
        return mongoTemplate.find(query,SmartMeter.class);
    }

    public List getUserWithSmartMetersPending(String userId) {
        Query query = new Query().addCriteria(Criteria.where("userId").is(userId).and("approvalStatus").is("Pending"));
        return mongoTemplate.find(query,SmartMeter.class);
    }

    public int getCountOfSmartMeters(String providerId) {
        Query query = new Query().addCriteria(Criteria.where("providerId").is(providerId));
        return mongoTemplate.find(query,SmartMeter.class).size();
    }
    public void updateProviderId(String smartMeterId, String providerIdToBeChanged) {
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
        Update update = new Update();
        update.set("providerId",providerIdToBeChanged);
        System.out.println(update);
        mongoTemplate.findAndModify(query,update,SmartMeter.class);
    }
}
