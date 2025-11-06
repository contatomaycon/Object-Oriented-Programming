package com.example.vehicle.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados para criação de um novo modelo")
public record ModelRequest(
  @Schema(description = "Nome do modelo", required = true, example = "Corolla")
  @NotBlank String name,
  @Schema(description = "ID da marca do modelo", required = true, example = "1")
  @NotNull Long brandId
) {}


