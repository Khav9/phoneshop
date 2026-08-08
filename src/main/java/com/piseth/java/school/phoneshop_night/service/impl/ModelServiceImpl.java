package com.piseth.java.school.phoneshop_night.service.impl;

import com.piseth.java.school.phoneshop_night.entity.Model;
import com.piseth.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop_night.repository.ModelRepository;
import com.piseth.java.school.phoneshop_night.service.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    //because it douplicate from controller
    //private BrandService brandService;

    @Override
    public Model save(Model model) {
//        Integer brandId = model.getBrand().getId();
//        brandService.getById(brandId);
        return modelRepository.save(model);
    }

    @Override
    public List<Model> findByBrand(Long brandId) {
        return modelRepository.findByBrandId(brandId);
    }

    @Override
    public Model getById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(   "Model", id));
    }
}
