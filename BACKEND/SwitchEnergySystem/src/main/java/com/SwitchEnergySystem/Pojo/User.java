package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "User")
public class User {
   public User() {
        userId="";
       userName="";
        password = "";
        role = "";
    }

    private String userId;
   private String userName;
    private String password;
    private String role;

}
