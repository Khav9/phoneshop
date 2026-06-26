package com.piseth.java.school.phoneshop_night.service.impl;

import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop_night.repository.BrandRepository;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import com.piseth.java.school.phoneshop_night.spec.BrandFilter;
import com.piseth.java.school.phoneshop_night.spec.BrandSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.piseth.java.school.phoneshop_night.service.util.PageUtil;

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
    public List<Brand> getBrands(String name) {
        return brandRepository.findByNameContaining(name );
    }

    @Override
    public Page<Brand> getBrands(Map<String, String> params) {
        BrandFilter brandFilter = new BrandFilter();
        if (params.containsKey("name")){
            String name = params.get("name");
            brandFilter.setName(name);
        }
        if (params.containsKey("id")){
            String id = params.get("id");
            brandFilter.setId(Integer.parseInt(id));
        }

        //TODO: add to page function
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if(params.containsKey(PageUtil.PAGE_LIMIT)){
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }
        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if(params.containsKey(PageUtil.PAGE_LIMIT)){
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

        BrandSpec brandSpec = new BrandSpec(brandFilter);
        Page<Brand> page = brandRepository.findAll(brandSpec, pageable);

        return page;
    }
}
