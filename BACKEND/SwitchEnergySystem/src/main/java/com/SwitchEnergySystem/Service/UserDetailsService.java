package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.UserDetails;
import com.SwitchEnergySystem.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;
    public List<UserDetails> viewUserDetails(String userId) {
        return userDetailsRepository.viewUserDetails(userId);
    }
}
