package com.example.vehicle.api.dto;

import com.example.vehicle.domain.model.VehicleStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record VehicleCreateRequest(
  @NotNull Long modelId,
  @NotNull @Min(1900) @Max(2100) Integer year,
  @NotBlank String color,
  @NotNull @DecimalMin("0.0") BigDecimal price,
  @NotNull @Min(0) Long mileage,
  @NotNull VehicleStatus status
) {}


