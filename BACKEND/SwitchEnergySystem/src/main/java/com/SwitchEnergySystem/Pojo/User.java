package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "User")
public class User {
    User() {
        userId="";
        password = "";
        role = "";
        providerId = "DrEvil101";
//        smartMeterId ="";
    }

    private String userId;//for user random id will be generated. for admin we need to give id
    private String password;
    private String role;
    @Id
    private String smartMeterId;
    private String providerId;

}
