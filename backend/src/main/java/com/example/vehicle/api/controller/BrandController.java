package com.example.vehicle.api.controller;

import com.example.vehicle.api.dto.BrandRequest;
import com.example.vehicle.api.dto.BrandResponse;
import com.example.vehicle.domain.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/brands")
@Tag(name = "Brands", description = "API para gerenciamento de marcas de veículos")
public class BrandController {
  private final BrandService brandService;
  public BrandController(BrandService brandService) { this.brandService = brandService; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Criar nova marca", description = "Cria uma nova marca de veículo")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Marca criada com sucesso",
          content = @Content(schema = @Schema(implementation = BrandResponse.class))),
      @ApiResponse(responseCode = "400", description = "Dados inválidos ou marca já existe")
  })
  public BrandResponse create(@RequestBody @Valid BrandRequest request) { 
    return brandService.create(request); 
  }

  @GetMapping
  @Operation(summary = "Listar todas as marcas", description = "Retorna uma lista com todas as marcas cadastradas")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Lista de marcas retornada com sucesso",
          content = @Content(schema = @Schema(implementation = BrandResponse.class)))
  })
  public List<BrandResponse> list() { 
    return brandService.list(); 
  }
}


