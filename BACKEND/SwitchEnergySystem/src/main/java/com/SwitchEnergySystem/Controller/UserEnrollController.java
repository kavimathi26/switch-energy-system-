package com.SwitchEnergySystem.Controller;


import com.SwitchEnergySystem.Pojo.Login;
import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.Service.UserEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserEnrollController {
    @Autowired
    UserEnrollService userEnrollService;
    @GetMapping("/view")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List viewAllUsers() {
        return userEnrollService.viewAllUsers();
    }
    @PostMapping("/enroll")
    public void enrollUser(@RequestBody User user) {
        userEnrollService.enrollUser(user);
    }

    @GetMapping("/findRole/userName/{userName}")
//    @PreAuthorize("hasAuthority('USER')")

    public String findRole(@PathVariable String userName) {

        return userEnrollService.findRole(userName);
    }
}
