package com.piseth.java.school.phoneshop_night.service.impl;

import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop_night.repository.BrandRepository;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository  brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()){
            return brandOptional.get();
        }
//        throw new ApiException(HttpStatus.NOT_FOUND, "Brand with id= %d not found".formatted(id));
        throw new ResourceNotFoundException("Brand", id);
    }

    @Override
    public Brand update(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName());
        return brandRepository.save(brand); //save if have data so it will create new one
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll() ;
    }

    @Override
    public List<Brand> getBrands(String name) {
        return brandRepository.findByNameContaining(name );
    }
}
