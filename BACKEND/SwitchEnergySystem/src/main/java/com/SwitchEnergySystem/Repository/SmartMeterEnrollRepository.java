package com.SwitchEnergySystem.Repository;


import com.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.Pojo.ReadingsArray;
import com.SwitchEnergySystem.Pojo.SmartMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;
import java.util.Random;


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
    public double amountToBePaidForAParticularSmartMeter(String providerId) {
        Query query = new Query().addCriteria(Criteria.where("providerId").is(providerId));
        System.out.println(mongoTemplate.find(query,Provider.class).get(0).getAmountChargedPerUnit());
        double amount = mongoTemplate.find(query,Provider.class).get(0).getAmountChargedPerUnit();
        return amount;
    }

    public void enrollReadingsForAParticularSmartMeterId(String smartMeterId,String providerId) {
        ReadingsArray readingsArray = new ReadingsArray(smartMeterId);
        readingsArray.setDate(java.time.LocalDate.now());
        readingsArray.setTimeStamp(System.currentTimeMillis());
        Random r = new Random();
        double randomValue = 10 + (100 - 10) * r.nextDouble();
        readingsArray.setReading(randomValue);
        mongoTemplate.save(readingsArray);
        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId).and("providerId").is(providerId));
        Update update = new Update();
        double reading = readingsArray.getReading();
        double finalReading = Math.round(reading * 10000.0) / 10000.0;
        update.set("totalReadings",finalReading);
//        amountToBePaidForAParticularSmartMeter(smartMeterId);
        double amount = readingsArray.getReading()*amountToBePaidForAParticularSmartMeter(providerId);
        double finalAmount = Math.round(amount * 100.0) / 100.0;
        update.set("amountToBePaid",finalAmount);
        System.out.println(finalAmount);
        mongoTemplate.findAndModify(query,update,SmartMeter.class);
    }
//    @Scheduled(cron = "*/10 * * * * *")
//    public void display() {
//
//    }
//    public void updateReadings(String smartMeterId) {
//        Query query = new Query().addCriteria(Criteria.where("smartMeterId").is(smartMeterId));
//        Update update = new Update();
//        update.set("date",java.time.LocalDate.now());
//        update.set("timeStamp",System.currentTimeMillis());
//        Random r = new Random();
//        double randomValue = 10 + (100 - 10) * r.nextDouble();
//        update.set("reading",randomValue);
//        mongoTemplate.findAndModify(query,update,ReadingsArray.class);
//        System.out.println(System.currentTimeMillis());
//    }
    public void enrollUserSettings(String userId) {
        SmartMeter smartMeter = new SmartMeter();
        smartMeter.setUserId(userId);
        System.out.println(smartMeter);
        mongoTemplate.save(smartMeter);
    }
    public void enrollSmartMeter(SmartMeter smartMeter) {
        mongoTemplate.save(smartMeter);
        System.out.println(smartMeter.getProviderId());
        updateSmartMeterCountForAProviderId(smartMeter.getProviderId());
        enrollReadingsForAParticularSmartMeterId(smartMeter.getSmartMeterId(),smartMeter.getProviderId());
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
