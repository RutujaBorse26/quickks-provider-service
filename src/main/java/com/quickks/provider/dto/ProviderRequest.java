package com.quickks.provider.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProviderRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String category;

    @NotBlank(message = "Phone is mandatory")
    @Pattern(regexp = "\\d{10}", message = "Phone must contain exactly 10 digits")
    private String phone;

    @NotBlank(message = "City is mandatory")
    private String city;

    private Double rating;

    // Default constructor
    public ProviderRequest() {
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}