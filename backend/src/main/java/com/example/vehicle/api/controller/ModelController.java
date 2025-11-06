package com.example.vehicle.api.controller;

import com.example.vehicle.api.dto.ModelRequest;
import com.example.vehicle.api.dto.ModelResponse;
import com.example.vehicle.domain.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {
  private final ModelService modelService;
  public ModelController(ModelService modelService) { this.modelService = modelService; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ModelResponse create(@RequestBody @Valid ModelRequest request) { return modelService.create(request); }

  @GetMapping
  public List<ModelResponse> list(@RequestParam(value = "brandId", required = false) Long brandId) {
    if (brandId != null) return modelService.listByBrand(brandId);
    return modelService.listAll();
  }
}


