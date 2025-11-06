package com.example.vehicle.api.dto;

import com.example.vehicle.domain.model.VehicleStatus;
import java.math.BigDecimal;

public record VehicleResponse(
  Long id,
  Long brandId,
  String brandName,
  Long modelId,
  String modelName,
  Integer year,
  String color,
  BigDecimal price,
  Long mileage,
  VehicleStatus status
) {}


