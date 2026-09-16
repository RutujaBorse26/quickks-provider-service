package com.quickks.provider.service;

import java.util.List;

import com.quickks.provider.dto.ProviderRequest;
import com.quickks.provider.entity.Provider;

public interface ProviderService {

    Provider addProvider(ProviderRequest request);

    List<Provider> getAllProviders();

    List<Provider> searchByCity(String city);

    void deleteProvider(Long id);
}
