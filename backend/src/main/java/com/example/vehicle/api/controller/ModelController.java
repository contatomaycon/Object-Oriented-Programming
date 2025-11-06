package com.example.vehicle.api.controller;

import com.example.vehicle.api.dto.ModelRequest;
import com.example.vehicle.api.dto.ModelResponse;
import com.example.vehicle.domain.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/models")
@Tag(name = "Models", description = "API para gerenciamento de modelos de veículos")
public class ModelController {
  private final ModelService modelService;
  public ModelController(ModelService modelService) { this.modelService = modelService; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Criar novo modelo", description = "Cria um novo modelo de veículo associado a uma marca")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Modelo criado com sucesso",
          content = @Content(schema = @Schema(implementation = ModelResponse.class))),
      @ApiResponse(responseCode = "400", description = "Dados inválidos ou modelo já existe para a marca"),
      @ApiResponse(responseCode = "404", description = "Marca não encontrada")
  })
  public ModelResponse create(@RequestBody @Valid ModelRequest request) { 
    return modelService.create(request); 
  }

  @GetMapping
  @Operation(summary = "Listar modelos", description = "Retorna lista de modelos. Pode filtrar por marca usando o parâmetro brandId")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de modelos retornada com sucesso",
          content = @Content(schema = @Schema(implementation = ModelResponse.class)))
  })
  public List<ModelResponse> list(
      @Parameter(description = "ID da marca para filtrar modelos (opcional)", example = "1")
      @RequestParam(value = "brandId", required = false) Long brandId) {
    if (brandId != null) return modelService.listByBrand(brandId);
    return modelService.listAll();
  }
}


