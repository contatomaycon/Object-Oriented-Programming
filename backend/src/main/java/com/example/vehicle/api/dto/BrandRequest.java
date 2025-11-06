package com.example.vehicle.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Dados para criação de uma nova marca")
public record BrandRequest(
  @Schema(description = "Nome da marca", required = true, example = "Toyota")
  @NotBlank String name
) {}


