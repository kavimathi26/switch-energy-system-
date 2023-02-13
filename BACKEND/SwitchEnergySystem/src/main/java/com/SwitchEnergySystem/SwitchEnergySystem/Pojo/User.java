package com.SwitchEnergySystem.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    User() {
        userId = "";
        password = "";
        role = "";
        smartMeterId = "";
        providerName = "";
    }
    private String userId;
    private String password;
    private String role;
    private String smartMeterId;
    private String providerName;

}
