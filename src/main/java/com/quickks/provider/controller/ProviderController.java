package com.quickks.provider.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickks.provider.dto.ProviderRequest;
import com.quickks.provider.entity.Provider;
import com.quickks.provider.service.ProviderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/providers")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // POST - Add a new provider
    @PostMapping
    public ResponseEntity<Provider> addProvider(
            @Valid @RequestBody ProviderRequest request) {

        Provider provider = providerService.addProvider(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(provider);
    }

    // GET - Get all providers
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {

        List<Provider> providers = providerService.getAllProviders();

        return ResponseEntity.ok(providers);
    }

    // GET - Search providers by city
    @GetMapping("/search")
    public ResponseEntity<List<Provider>> searchByCity(
            @RequestParam String city) {

        List<Provider> providers = providerService.searchByCity(city);

        return ResponseEntity.ok(providers);
    }

    // DELETE - Delete provider by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProvider(
            @PathVariable Long id) {

        providerService.deleteProvider(id);

        return ResponseEntity.ok("Provider deleted successfully");
    }
}