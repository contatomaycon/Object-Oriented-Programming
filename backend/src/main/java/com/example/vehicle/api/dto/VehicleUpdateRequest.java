package com.example.vehicle.api.dto;

import com.example.vehicle.domain.model.VehicleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;

@Schema(description = "Dados para atualização parcial de um veículo")
public record VehicleUpdateRequest(
  @Schema(description = "Novo preço do veículo", example = "90000.00")
  @DecimalMin("0.0") BigDecimal price,
  @Schema(description = "Nova quilometragem do veículo", example = "50000")
  @Min(0) Long mileage,
  @Schema(description = "Novo status do veículo", example = "SOLD")
  VehicleStatus status
) {}


