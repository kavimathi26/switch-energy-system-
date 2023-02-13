package com.SwitchEnergySystem.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "SmartMeter")
public class SmartMeter {
    public SmartMeter() {
        providerId = "";
        approvalStatus = "pending";
        totalReadings = 0.0;
    }
    @Id
    private String smartMeterId;
    private String providerId;
    private String approvalStatus;
    private double totalReadings;
}
