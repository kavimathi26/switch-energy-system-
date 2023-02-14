package com.SwitchEnergySystem.Controller;

import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Service.SmartMeterEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/smartmeter")
public class SmartMeterEnrollController {
@Autowired
SmartMeterEnrollService smartMeterEnrollService;
//@PostMapping("/enroll")
//public String enrollSmartMeter(@RequestBody SmartMeter smartMeter) {
//    smartMeterEnrollService.enrollSmartMeter(smartMeter);
//    return "Smart Meter enrolled";
//}
@PutMapping("/approvalstatus/{approvalStatus}/smartmeterid/{smartMeterId}")
    public SmartMeter approvalStatus(@PathVariable String approvalStatus, @PathVariable String smartMeterId) {
    return smartMeterEnrollService.approvalstatus(approvalStatus,smartMeterId);

}
@GetMapping("/providerId/{providerId}")
    public List viewListOfSmartMetersForAParticularProviderId(@PathVariable String providerId) {
    return smartMeterEnrollService.viewListOfSmartMetersForAParticularProviderId(providerId);
}
}
