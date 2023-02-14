package com.SwitchEnergySystem.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.SwitchEnergySystem.Repository.SmartMeterEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartMeterEnrollService {
    @Autowired
    SmartMeterEnrollRepository smartMeterEnrollRepository;
//    public void enrollSmartMeter(SmartMeter smartMeter) {
//    smartMeterEnrollRepository.enrollSmartMeter(smartMeter);
//    }

    public SmartMeter approvalstatus(String approvalStatus,String smartMeterId) {
        return smartMeterEnrollRepository.approvalstatus(approvalStatus,smartMeterId);
    }

    public List viewListOfSmartMetersForAParticularProviderId(String providerId) {
        return smartMeterEnrollRepository.viewListOfSmartMetersForAParticularProviderId(providerId);
    }
}
