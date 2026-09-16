package com.quickks.provider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickks.provider.entity.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    List<Provider> findByCityIgnoreCase(String city);
}