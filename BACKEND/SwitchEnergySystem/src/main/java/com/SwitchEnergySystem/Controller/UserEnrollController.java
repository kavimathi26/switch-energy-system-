package com.SwitchEnergySystem.Controller;


import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Service.UserEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserEnrollController {
    @Autowired
    UserEnrollService userEnrollService;
    @GetMapping("/view")
    public List viewAllUsers() {
        return userEnrollService.viewAllUsers();
    }
    @PostMapping("/enroll")
    public void enrollUser(@RequestBody User user) {
        userEnrollService.enrollUser(user);
    }
}
