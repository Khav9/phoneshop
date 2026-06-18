package com.piseth.java.school.phoneshop_night.service;

import com.piseth.java.school.phoneshop_night.entity.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
}
