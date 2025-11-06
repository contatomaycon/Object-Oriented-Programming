package com.example.vehicle.domain.service;

import com.example.vehicle.api.dto.BrandRequest;
import com.example.vehicle.api.dto.BrandResponse;
import java.util.List;

public interface BrandService {
  BrandResponse create(BrandRequest request);
  List<BrandResponse> list();
}


