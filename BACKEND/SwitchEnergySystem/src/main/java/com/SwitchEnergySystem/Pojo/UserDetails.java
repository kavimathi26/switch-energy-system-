package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "UserDetails")
public class UserDetails {
    private String userId;
    private String smartMeterId;
    private double totalReadings;
    private double amountToBePaid;
    private String energyProvider;

}
