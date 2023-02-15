package com.SwitchEnergySystem.Repository;

import com.SwitchEnergySystem.Pojo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;

@Repository
public class ProviderEnrollRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    public void enrollProvider(Provider provider) {
        mongoTemplate.save(provider);
    }

    public List<Provider> viewProviders() {
        return mongoTemplate.findAll(Provider.class);
    }
    public Provider getOneProvider(String providerId) {
        return mongoTemplate.findOne(Query.query(Criteria.where("providerId").is(providerId)), Provider.class);
    }
    public Provider visibiltyUpdate(String visibility,String providerId) {
        Query query = new Query().addCriteria(Criteria.where("providerId").is(providerId));
        Update update = new Update();
        update.set("visibility",visibility);
        return mongoTemplate.findAndModify(query,update, Provider.class);
    }

    public List<Provider> getTopProviders(int page, int size) {
            Query query = new Query();
//            query.with(Sort.by(Sort.Direction.DESC, ""));
//            query.skip(Integer.parseInt(page) * Integer.parseInt(size)).limit(Integer.parseInt(size));
            query.skip(page*size).limit(size);
            return mongoTemplate.find(query,Provider.class);
        }

    public List viewProviderIds() {
        Query query = new Query();
        query.fields()
                .exclude("providerName","countOfSmartMeters","amountChargedPerUnit","visibility");
//                .include("providerId")
//                .include("status");
       return mongoTemplate.find(query,Provider.class);
    }
}
