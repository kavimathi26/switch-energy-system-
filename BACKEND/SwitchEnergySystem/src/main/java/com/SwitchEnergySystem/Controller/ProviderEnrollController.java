package com.SwitchEnergySystem.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.SwitchEnergySystem.Service.ProviderEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/provider")
public class ProviderEnrollController {
    @Autowired
    ProviderEnrollService providerEnrollService;
    @GetMapping("/viewproviders")
    public List<Provider> viewProviders() {
        return providerEnrollService.viewProviders();
    }
    @PostMapping("/enroll")
    public String enrollProvider(@RequestBody Provider provider) {
        providerEnrollService.enrollProvider(provider);
        return "Provided enrolled";
    }
    @PutMapping("/visibility/{visibility}/providerid/{providerId}")
    public Provider visibiltyUpdate(@PathVariable String visibility,@PathVariable String providerId) {
       return providerEnrollService.visibiltyUpdate(visibility,providerId);
    }
    @GetMapping("/getoneprovider/{providerId}")
    public Provider getoneprovider(@PathVariable String providerId) {
        return providerEnrollService.getoneprovider(providerId);
    }

    @GetMapping("/topproviders/page/{pageNo}/limit/{limit}")
    public List<Provider> getTopProviders(@PathVariable int pageNo, @PathVariable int limit) {
//        int pageNo = page;
//        if(pageNo == 0) {
//            pageNo = 0;
//        }
//        int limit = size;
//        if(limit == 0) {
//            limit = 10;
//        }

        return providerEnrollService.getTopProviders(pageNo, limit);
    }

}
