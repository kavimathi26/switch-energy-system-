package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "Readings")
@Getter
@Setter
public class ReadingsArray {
    private String smartMeterId;
    private LocalDate date;
    private long timeStamp;
    private double reading;
   public ReadingsArray(String smartMeterId) {
       this.smartMeterId = smartMeterId;
        date = null;
        timeStamp = 0;
        reading = 0.0;
    }
}

