package com.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Service.SmartMeterEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/smartmeter")

public class SmartMeterEnrollController {
@Autowired
SmartMeterEnrollService smartMeterEnrollService;
@PostMapping("/enroll")

public String enrollSmartMeter(@RequestBody SmartMeter smartMeter) {
    smartMeterEnrollService.enrollSmartMeter(smartMeter);
    return "Smart Meter enrolled";
}
@PutMapping("/approvalstatus/{approvalStatus}/smartmeterid/{smartMeterId}")
@PreAuthorize("hasAuthority('ADMIN')")

    public SmartMeter approvalStatus(@PathVariable String approvalStatus, @PathVariable String smartMeterId) {
    return smartMeterEnrollService.approvalstatus(approvalStatus,smartMeterId);

}
@GetMapping("/providerId/{providerId}")
@PreAuthorize("hasAuthority('USER')")

    public List viewListOfSmartMetersForAParticularProviderId(@PathVariable String providerId) {
    return smartMeterEnrollService.viewListOfSmartMetersForAParticularProviderId(providerId);
}

@GetMapping("/userName/{userName}")
@PreAuthorize("hasAuthority('USER')")

    public List getUserWithSmartMeters(@PathVariable String userName) {
    return smartMeterEnrollService.getUserWithSmartMeters(userName);
}
@PutMapping("/approve/{smartMeterId}")
@PreAuthorize("hasAuthority('ADMIN')")
    public void approveSmartMeter(@PathVariable String smartMeterId) {
    smartMeterEnrollService.approveSmartMeter(smartMeterId);
}
@GetMapping("/pending/userName/{userName}")
@PreAuthorize("hasAuthority('ADMIN')")
    public List getUserWithSmartMetersPending(@PathVariable String userName) {
    return smartMeterEnrollService.getUserWithSmartMetersPending(userName);
}
@GetMapping("/count/providerId/{providerId}")
@PreAuthorize("hasAuthority('ADMIN')")
    public int getCountOfSmartMeters(@PathVariable String providerId) {
//    smartMeterEnrollService.addReadings();
    return smartMeterEnrollService.getCountOfSmartMeters(providerId);

}
@PutMapping("/update/smartMeterId/{smartMeterId}/providerIdToBeChanged/{providerIdToBeChanged}")
    public void updateProviderId(@PathVariable String smartMeterId,@PathVariable String providerIdToBeChanged) {
    smartMeterEnrollService.updateProviderId(smartMeterId,providerIdToBeChanged);
}

}
