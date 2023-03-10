package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "provider")
public class Provider {
    Provider(){
        providerId = "";
        providerName = "";
        countOfSmartMeters = 0;
        amountChargedPerUnit = 0.0;
        visibility = "Disable";
    }
    private String providerId;
    private String providerName;
    private long countOfSmartMeters;
    private double amountChargedPerUnit;
    private String visibility;
}
