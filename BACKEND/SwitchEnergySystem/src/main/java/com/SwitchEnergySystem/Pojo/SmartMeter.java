package com.SwitchEnergySystem.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "SmartMeter")
public class SmartMeter {
    @Id
    private String smartMeterId;
    private String providerId;
    private String approvalStatus;
    private double totalReadings;
    private double amountToBePaid;
    
    public SmartMeter() {
        providerId = "DrEvil101";
        approvalStatus = "pending";
        totalReadings = 0.0;
        amountToBePaid = 0.0;
    }
}
