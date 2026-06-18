package com.piseth.java.school.phoneshop_night.controller;

import com.piseth.java.school.phoneshop_night.dto.BrandDto;
import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import com.piseth.java.school.phoneshop_night.service.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //come with response body. RestController != Controller
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService  brandService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDto  brandDto) {
        Brand brand = Mapper.toBrand(brandDto);
        brand = brandService.create(brand);
        return ResponseEntity.ok(brand);
    }
}
