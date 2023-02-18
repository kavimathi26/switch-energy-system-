package com.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.Service.ProviderEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/provider")
public class ProviderEnrollController {
    @Autowired
    ProviderEnrollService providerEnrollService;
    @GetMapping("/viewproviders")
    @PreAuthorize("hasAuthority('USER')")

    public List<Provider> viewProviders() {
        return providerEnrollService.viewProviders();
    }
    @GetMapping("/viewproviderids")
    @PreAuthorize("hasAuthority('USER')")

    public  List viewProviderIds() {
        return providerEnrollService.viewProviderIds();
    }
    @PostMapping("/enroll")
//    @PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")

    public String enrollProvider(@RequestBody Provider provider) {
        providerEnrollService.enrollProvider(provider);
        return "Provided enrolled";
    }
    @PutMapping("/visibility/{visibility}/providerid/{providerId}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("hasAuthority('ADMIN')")


    public Provider visibiltyUpdate(@PathVariable String visibility,@PathVariable String providerId) {
       return providerEnrollService.visibiltyUpdate(visibility,providerId);
    }
    @GetMapping("/getoneprovider/{providerId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Provider getoneprovider(@PathVariable String providerId) {
        return providerEnrollService.getoneprovider(providerId);
    }

    @GetMapping("/topprovidersforadmin/page/{pageNo}/limit/{limit}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Provider> getTopProvidersForAdmin(@PathVariable int pageNo, @PathVariable int limit) {
        return providerEnrollService.getTopProvidersForAdmin(pageNo, limit);
    }
    @GetMapping("/topprovidersforuser/page/{pageNo}/limit/{limit}")
    @PreAuthorize("hasAuthority('USER')")
    public List<Provider> getTopProvidersForUser(@PathVariable int pageNo, @PathVariable int limit) {
        return providerEnrollService.getTopProvidersForUser(pageNo, limit);
    }
}
