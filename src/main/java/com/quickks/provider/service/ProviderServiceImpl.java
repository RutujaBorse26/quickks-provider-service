package com.quickks.provider.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quickks.provider.dto.ProviderRequest;
import com.quickks.provider.entity.Provider;
import com.quickks.provider.exception.ProviderNotFoundException;
import com.quickks.provider.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider addProvider(ProviderRequest request) {

        Provider provider = new Provider();

        provider.setName(request.getName());
        provider.setCategory(request.getCategory());
        provider.setPhone(request.getPhone());
        provider.setCity(request.getCity());

        if (request.getRating() != null) {
            provider.setRating(request.getRating());
        }

        return providerRepository.save(provider);
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public List<Provider> searchByCity(String city) {
        return providerRepository.findByCityIgnoreCase(city);
    }

    @Override
    public void deleteProvider(Long id) {

        if (!providerRepository.existsById(id)) {
            throw new ProviderNotFoundException(
                    "Provider with ID " + id + " not found"
            );
        }

        providerRepository.deleteById(id);
    }
}