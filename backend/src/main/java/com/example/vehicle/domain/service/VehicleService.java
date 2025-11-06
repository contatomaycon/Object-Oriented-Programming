package com.example.vehicle.domain.service;

import com.example.vehicle.api.dto.VehicleCreateRequest;
import com.example.vehicle.api.dto.VehicleUpdateRequest;
import com.example.vehicle.api.dto.VehicleResponse;
import com.example.vehicle.domain.model.VehicleStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;

public interface VehicleService {
  VehicleResponse create(VehicleCreateRequest request);
  VehicleResponse get(Long id);
  VehicleResponse update(Long id, VehicleUpdateRequest request);
  void delete(Long id);
  Page<VehicleResponse> search(Long brandId, Long modelId, Integer year, VehicleStatus status,
                               BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
}


