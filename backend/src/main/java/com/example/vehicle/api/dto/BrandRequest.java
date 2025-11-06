package com.example.vehicle.api.dto;

import jakarta.validation.constraints.NotBlank;

public record BrandRequest(@NotBlank String name) {}


