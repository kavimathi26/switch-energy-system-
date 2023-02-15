package com.SwitchEnergySystem.Controller;
import com.SwitchEnergySystem.Pojo.UserDetails;
import com.SwitchEnergySystem.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
    @Autowired
    UserDetailsService userDetailsService;
    @GetMapping("/userId/{userId}")
    public List<UserDetails> viewUserDetails(@PathVariable String userId) {
        return userDetailsService.viewUserDetails(userId);
    }

}
