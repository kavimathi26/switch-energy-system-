package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.SmartMeter;
import com.SwitchEnergySystem.Repository.SmartMeterEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartMeterEnrollService {

    @Autowired
    SmartMeterEnrollRepository smartMeterEnrollRepository;
    public void enrollSmartMeter(SmartMeter smartMeter) {
    smartMeterEnrollRepository.enrollSmartMeter(smartMeter);
    }

    public SmartMeter approvalstatus(String approvalStatus, String smartMeterId) {
        return smartMeterEnrollRepository.approvalstatus(approvalStatus,smartMeterId);
    }

    public List viewListOfSmartMetersForAParticularProviderId(String providerId) {
        return smartMeterEnrollRepository.viewListOfSmartMetersForAParticularProviderId(providerId);
    }

    public List getUserWithSmartMeters(String userName) {
        return smartMeterEnrollRepository.getUserWithSmartMeters(userName);
    }

    public void approveSmartMeter(String smartMeterId) {
//        smartMeterEnrollRepository.approveSmartMeter(smartMeterId);
    }
    public List getUserWithSmartMetersPending(String userName) {
       return smartMeterEnrollRepository.getUserWithSmartMetersPending(userName);
    }

    public int getCountOfSmartMeters(String providerId) {
    return smartMeterEnrollRepository.getCountOfSmartMeters(providerId);
    }

    public void updateProviderId(String providerId, String providerIdToBeChanged) {
        smartMeterEnrollRepository.updateProviderId(providerId,providerIdToBeChanged);
    }

    public List getUserWithSmartMetersPendingForAdminApproval() {
        return smartMeterEnrollRepository.getUserWithSmartMetersPendingForAdminApproval();
    }
}
