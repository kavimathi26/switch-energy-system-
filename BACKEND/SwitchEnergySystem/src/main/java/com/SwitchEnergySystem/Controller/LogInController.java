package com.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Repository.LogInRepository;
import com.SwitchEnergySystem.Service.JwtService;
import com.SwitchEnergySystem.Service.LogInService;
import com.SwitchEnergySystem.dto.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LogInController {

    @Autowired
    LogInRepository logInRepository;
    @Autowired
    LogInService logInService;
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public Login loginApi(@RequestBody Login login) {
        logInService.loginApi(login);
        return login;
    }
    @PostMapping("/authenticate")
    public JwtRequest authenticateAndGetToken(@RequestBody User user) {
        System.out.println("kavi authenticate");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        System.out.println("37th line");
        System.out.println(authentication.isAuthenticated());
        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUserName());
            return new JwtRequest(token);
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}

