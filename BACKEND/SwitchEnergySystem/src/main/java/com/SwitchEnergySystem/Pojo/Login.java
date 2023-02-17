package com.SwitchEnergySystem.Pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "LogIn")
public class Login {
    private String userName;
    private String password;
    private String role;
}
