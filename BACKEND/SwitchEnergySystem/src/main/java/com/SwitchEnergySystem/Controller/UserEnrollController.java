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
//    @PostMapping("/enroll")
//    public void enrollUser(@RequestBody User user) {
//       userEnrollService.enrollUser(user);
////        return "User Enrolled";
//    }
//    @GetMapping("/viewoneuser/userId/{userId}")
//    public List<User> viewoneuser(@PathVariable String userId) {
//        return userEnrollService.viewoneuser(userId);
//    }
//    @GetMapping("/view/userId/{userId}/smartMeterId/{smartMeterId}")
////    http://localhost:8080/user/view/userId/${userId}/smartMeter/${smartMeterId}
//    public List viewParticularSmartMeterForAUser(@PathVariable String smartMeterId) {
//        return userEnrollService.viewParticularSmartMeterForAUser(smartMeterId);
//    }
//    @PutMapping("/smartmeterid/{smartMeterId}/providerid/{providerId}/userId/{userId}")
//    public void updateProivder(@PathVariable String smartMeterId,@PathVariable String providerId,@PathVariable String userId) {
//       userEnrollService.updateProivder(smartMeterId,providerId,userId);
//    }
//    @PostMapping("/userId/{userId}")
//    public void createUser(@PathVariable String userId) {
//        userEnrollService.createUser(userId);
//    }
//    @GetMapping("/userId/{userId}")
//    public int countUser(@PathVariable String userId) {
//       return  userEnrollService.countUser(userId);
//    }
}
