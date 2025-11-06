package com.example.vehicle.infrastructure.service;

import com.example.vehicle.api.dto.ModelRequest;
import com.example.vehicle.api.dto.ModelResponse;
import com.example.vehicle.domain.model.Brand;
import com.example.vehicle.domain.model.Model;
import com.example.vehicle.domain.repository.BrandRepository;
import com.example.vehicle.domain.repository.ModelRepository;
import com.example.vehicle.domain.service.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ModelServiceImpl implements ModelService {
  private final ModelRepository modelRepository;
  private final BrandRepository brandRepository;

  public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
    this.modelRepository = modelRepository;
    this.brandRepository = brandRepository;
  }

  public ModelResponse create(ModelRequest request) {
    Brand brand = brandRepository.findById(request.brandId()).orElseThrow();
    Model m = new Model();
    m.setName(request.name().trim());
    m.setBrand(brand);
    m = modelRepository.save(m);
    return new ModelResponse(m.getId(), m.getName(), brand.getId(), brand.getName());
  }

  @Transactional(readOnly = true)
  public List<ModelResponse> listByBrand(Long brandId) {
    return modelRepository.findByBrandId(brandId).stream()
      .map(m -> new ModelResponse(m.getId(), m.getName(), m.getBrand().getId(), m.getBrand().getName()))
      .toList();
  }

  @Transactional(readOnly = true)
  public List<ModelResponse> listAll() {
    return modelRepository.findAll().stream()
      .map(m -> new ModelResponse(m.getId(), m.getName(), m.getBrand().getId(), m.getBrand().getName()))
      .toList();
  }
}


