package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.LogInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    LogInRepository logInRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void loginApi(Login login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        logInRepository.loginApi(login);
    }
}
