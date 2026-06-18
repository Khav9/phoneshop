package com.piseth.java.school.phoneshop_night.service.util;

import com.piseth.java.school.phoneshop_night.dto.BrandDto;
import com.piseth.java.school.phoneshop_night.entity.Brand;

import javax.swing.text.html.parser.Entity;

public class Mapper {
    public static Brand toBrand(BrandDto brandDto){
        Brand brand = new Brand();
        brand.setId(brandDto.getId());
        brand.setName(brandDto.getName());
        return brand;
    }
}
