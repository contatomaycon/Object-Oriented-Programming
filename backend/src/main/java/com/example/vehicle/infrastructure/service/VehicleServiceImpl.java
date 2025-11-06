package com.example.vehicle.infrastructure.service;

import com.example.vehicle.api.dto.VehicleCreateRequest;
import com.example.vehicle.api.dto.VehicleUpdateRequest;
import com.example.vehicle.api.dto.VehicleResponse;
import com.example.vehicle.domain.model.*;
import com.example.vehicle.domain.repository.ModelRepository;
import com.example.vehicle.domain.repository.VehicleRepository;
import com.example.vehicle.domain.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
  private final VehicleRepository vehicleRepository;
  private final ModelRepository modelRepository;

  public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelRepository modelRepository) {
    this.vehicleRepository = vehicleRepository;
    this.modelRepository = modelRepository;
  }

  public VehicleResponse create(VehicleCreateRequest request) {
    Model model = modelRepository.findById(request.modelId()).orElseThrow();
    Vehicle v = new Vehicle();
    v.setModel(model);
    v.setYear(request.year());
    v.setColor(request.color().trim());
    v.setPrice(request.price());
    v.setMileage(request.mileage());
    v.setStatus(request.status());
    v = vehicleRepository.save(v);
    return toResponse(v);
  }

  @Transactional(readOnly = true)
  public VehicleResponse get(Long id) {
    Vehicle v = vehicleRepository.findById(id).orElseThrow();
    return toResponse(v);
  }

  public VehicleResponse update(Long id, VehicleUpdateRequest request) {
    Vehicle v = vehicleRepository.findById(id).orElseThrow();
    if (request.price() != null) v.setPrice(request.price());
    if (request.mileage() != null) v.setMileage(request.mileage());
    if (request.status() != null) v.setStatus(request.status());
    v = vehicleRepository.save(v);
    return toResponse(v);
  }

  public void delete(Long id) {
    Vehicle v = vehicleRepository.findById(id).orElseThrow();
    if (!(v.getStatus() == VehicleStatus.SOLD || v.getStatus() == VehicleStatus.DISCONTINUED))
      throw new IllegalStateException("only SOLD or DISCONTINUED can be removed");
    vehicleRepository.deleteById(id);
  }

  @Transactional(readOnly = true)
  public Page<VehicleResponse> search(Long brandId, Long modelId, Integer year, VehicleStatus status,
                                      BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
    Specification<Vehicle> spec = Specification.where(null);
    if (brandId != null) spec = spec.and((root, q, cb) -> cb.equal(root.join("model").join("brand").get("id"), brandId));
    if (modelId != null) spec = spec.and((root, q, cb) -> cb.equal(root.join("model").get("id"), modelId));
    if (year != null) spec = spec.and((root, q, cb) -> cb.equal(root.get("year"), year));
    if (status != null) spec = spec.and((root, q, cb) -> cb.equal(root.get("status"), status));
    if (minPrice != null) spec = spec.and((root, q, cb) -> cb.greaterThanOrEqualTo(root.get("price"), minPrice));
    if (maxPrice != null) spec = spec.and((root, q, cb) -> cb.lessThanOrEqualTo(root.get("price"), maxPrice));
    return vehicleRepository.findAll(spec, pageable).map(this::toResponse);
  }

  private VehicleResponse toResponse(Vehicle v) {
    Brand b = v.getModel().getBrand();
    return new VehicleResponse(
      v.getId(), b.getId(), b.getName(), v.getModel().getId(), v.getModel().getName(),
      v.getYear(), v.getColor(), v.getPrice(), v.getMileage(), v.getStatus()
    );
  }
}


