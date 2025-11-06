package com.example.vehicle.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModelRequest(@NotBlank String name, @NotNull Long brandId) {}


