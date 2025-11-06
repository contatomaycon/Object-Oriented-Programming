package com.example.vehicle.api.controller;

import com.example.vehicle.api.dto.VehicleCreateRequest;
import com.example.vehicle.api.dto.VehicleUpdateRequest;
import com.example.vehicle.api.dto.VehicleResponse;
import com.example.vehicle.domain.model.VehicleStatus;
import com.example.vehicle.domain.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
  private final VehicleService vehicleService;
  public VehicleController(VehicleService vehicleService) { this.vehicleService = vehicleService; }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public VehicleResponse create(@RequestBody @Valid VehicleCreateRequest request) { return vehicleService.create(request); }

  @GetMapping("/{id}")
  public VehicleResponse get(@PathVariable Long id) { return vehicleService.get(id); }

  @PatchMapping("/{id}")
  public VehicleResponse update(@PathVariable Long id, @RequestBody @Valid VehicleUpdateRequest request) { return vehicleService.update(id, request); }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) { vehicleService.delete(id); }

  @GetMapping
  public Page<VehicleResponse> search(
    @RequestParam(value = "brandId", required = false) Long brandId,
    @RequestParam(value = "modelId", required = false) Long modelId,
    @RequestParam(value = "year", required = false) Integer year,
    @RequestParam(value = "status", required = false) VehicleStatus status,
    @RequestParam(value = "minPrice", required = false) BigDecimal minPrice,
    @RequestParam(value = "maxPrice", required = false) BigDecimal maxPrice,
    @RequestParam(value = "page", defaultValue = "0") int page,
    @RequestParam(value = "size", defaultValue = "10") int size,
    @RequestParam(value = "sort", defaultValue = "id,desc") String sort
  ) {
    String[] s = sort.split(",");
    Sort.Direction d = s.length > 1 ? Sort.Direction.fromString(s[1]) : Sort.Direction.DESC;
    Pageable p = PageRequest.of(page, size, Sort.by(d, s[0]));
    return vehicleService.search(brandId, modelId, year, status, minPrice, maxPrice, p);
  }
}


