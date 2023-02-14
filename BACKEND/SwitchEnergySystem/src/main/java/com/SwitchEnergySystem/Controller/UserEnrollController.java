package com.SwitchEnergySystem.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.User;
import com.SwitchEnergySystem.SwitchEnergySystem.Service.UserEnrollService;
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
    public List<SmartMeter> enrollUser(@RequestBody User user) {
       return userEnrollService.enrollUser(user);
//        return "User Enrolled";
    }
    @GetMapping("/viewoneuser/userId/{userId}")
    public List<User> viewoneuser(@PathVariable String userId) {
        return userEnrollService.viewoneuser(userId);
    }
    @GetMapping("/view/userId/{userId}/id/{smartMeterId}")
    public List viewParticularSmartMeterForAUser(@PathVariable String smartMeterId) {
        return userEnrollService.viewParticularSmartMeterForAUser(smartMeterId);
    }
}
