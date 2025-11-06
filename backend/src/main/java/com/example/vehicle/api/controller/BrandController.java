package com.example.vehicle.api.controller;

import com.example.vehicle.api.dto.BrandRequest;
import com.example.vehicle.api.dto.BrandResponse;
import com.example.vehicle.domain.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
  private final BrandService brandService;
  public BrandController(BrandService brandService) { this.brandService = brandService; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BrandResponse create(@RequestBody @Valid BrandRequest request) { return brandService.create(request); }

  @GetMapping
  public List<BrandResponse> list() { return brandService.list(); }
}


