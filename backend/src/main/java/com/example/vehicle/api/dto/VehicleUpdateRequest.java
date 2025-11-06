package com.example.vehicle.api.dto;

import com.example.vehicle.domain.model.VehicleStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

public record VehicleUpdateRequest(
  @DecimalMin("0.0") BigDecimal price,
  @Min(0) Long mileage,
  VehicleStatus status
) {}


