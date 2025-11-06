package com.example.vehicle.domain.service;

import com.example.vehicle.api.dto.ModelRequest;
import com.example.vehicle.api.dto.ModelResponse;
import java.util.List;

public interface ModelService {
  ModelResponse create(ModelRequest request);
  List<ModelResponse> listByBrand(Long brandId);
  List<ModelResponse> listAll();
}


