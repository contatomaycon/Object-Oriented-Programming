package com.example.vehicle.infrastructure.service;

import com.example.vehicle.api.dto.BrandRequest;
import com.example.vehicle.api.dto.BrandResponse;
import com.example.vehicle.domain.model.Brand;
import com.example.vehicle.domain.repository.BrandRepository;
import com.example.vehicle.domain.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
  private final BrandRepository brandRepository;
  public BrandServiceImpl(BrandRepository brandRepository) { this.brandRepository = brandRepository; }

  public BrandResponse create(BrandRequest request) {
    Brand b = new Brand();
    b.setName(request.name().trim());
    b = brandRepository.save(b);
    return new BrandResponse(b.getId(), b.getName());
  }

  @Transactional(readOnly = true)
  public List<BrandResponse> list() {
    return brandRepository.findAll().stream()
      .map(b -> new BrandResponse(b.getId(), b.getName()))
      .toList();
  }
}


