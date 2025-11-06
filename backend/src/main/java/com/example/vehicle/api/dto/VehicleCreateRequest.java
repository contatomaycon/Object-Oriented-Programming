package com.example.vehicle.api.dto;

import com.example.vehicle.domain.model.VehicleStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "Dados para criação de um novo veículo")
public record VehicleCreateRequest(
  @Schema(description = "ID do modelo do veículo", required = true, example = "1")
  @NotNull Long modelId,
  @Schema(description = "Ano do veículo (1900-2100)", required = true, example = "2020")
  @NotNull @Min(1900) @Max(2100) Integer year,
  @Schema(description = "Cor do veículo", required = true, example = "Branco")
  @NotBlank String color,
  @Schema(description = "Preço do veículo", required = true, example = "85000.00")
  @NotNull @DecimalMin("0.0") BigDecimal price,
  @Schema(description = "Quilometragem do veículo", required = true, example = "45000")
  @NotNull @Min(0) Long mileage,
  @Schema(description = "Status do veículo", required = true, example = "AVAILABLE")
  @NotNull VehicleStatus status
) {}


