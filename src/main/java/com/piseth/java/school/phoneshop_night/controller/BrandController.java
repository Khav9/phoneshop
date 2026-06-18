package com.piseth.java.school.phoneshop_night.controller;

import com.piseth.java.school.phoneshop_night.dto.BrandDto;
import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import com.piseth.java.school.phoneshop_night.service.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //come with response body. RestController != Controller
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService  brandService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDto  brandDto) {
        Brand brand = Mapper.toBrand(brandDto);
        brand = brandService.create(brand);
        return ResponseEntity.ok(Mapper.toBrandDto(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable Integer id) {
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(Mapper.toBrandDto(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody BrandDto  brandDto) {
        Brand brand = Mapper.toBrand(brandDto);
        Brand updatedBrand = brandService.update(id, brand);
        return ResponseEntity.ok(Mapper.toBrandDto(updatedBrand));
    }
}
