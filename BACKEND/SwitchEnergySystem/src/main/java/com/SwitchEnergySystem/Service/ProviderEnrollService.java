package com.SwitchEnergySystem.Service;

import com.SwitchEnergySystem.Pojo.Provider;
import com.SwitchEnergySystem.Repository.ProviderEnrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderEnrollService {
    @Autowired
    ProviderEnrollRepository providerEnrollRepository;
    public void enrollProvider(Provider provider) {
        providerEnrollRepository.enrollProvider(provider);
    }

    public List<Provider> viewProviders() {
       return providerEnrollRepository.viewProviders();
    }

    public Provider visibiltyUpdate(String visibility,String providerId) {
       return providerEnrollRepository.visibiltyUpdate(visibility,providerId);
    }

    public Provider getoneprovider(String providerId) {
        return providerEnrollRepository.getOneProvider(providerId);
    }

    public List<Provider> getTopProvidersForAdmin(int page, int size) {
        return providerEnrollRepository.getTopProvidersForAdmin(page,size);
    }
    public List<Provider> getTopProvidersForUser(int page, int size) {
        return providerEnrollRepository.getTopProvidersForUser(page,size);
    }

    public List viewProviderIds() {
        return providerEnrollRepository.viewProviderIds();
    }



}
