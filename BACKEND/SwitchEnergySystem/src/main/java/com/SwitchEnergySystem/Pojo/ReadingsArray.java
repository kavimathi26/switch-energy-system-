package com.SwitchEnergySystem.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
@Getter
@Setter
public class ReadingsArray {
    private Date date;
    private long timeStamp;
    private double reading;
   public ReadingsArray() {
        date = null;
        timeStamp = 0;
        reading = 0.0;
    }
//    private ArrayList<ReadingsArray> readingsArray = new ArrayList<ReadingsArray>();
//    readingsArray.add(new ReadingsArray());
//    readingsArray.get(0).setDate();
}

