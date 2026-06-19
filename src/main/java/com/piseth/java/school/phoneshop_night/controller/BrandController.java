package com.piseth.java.school.phoneshop_night.controller;

import com.piseth.java.school.phoneshop_night.dto.BrandDto;
import com.piseth.java.school.phoneshop_night.entity.Brand;
import com.piseth.java.school.phoneshop_night.mapper.BrandMapper;
import com.piseth.java.school.phoneshop_night.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //come with response body. RestController != Controller
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService  brandService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDto  brandDto) {
//        Brand brand = Mapper.toBrand(brandDto);
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
        brand = brandService.create(brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDto(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable Integer id) {
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDto(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody BrandDto  brandDto) {
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDto);
        Brand updatedBrand = brandService.update(id, brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDto(updatedBrand));
    }

    @GetMapping()
    public ResponseEntity<?> getBrands() {
        List<BrandDto> list = brandService.getBrands().stream().map(brand -> BrandMapper.INSTANCE.toBrandDto(brand)).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("filter")
    public ResponseEntity<?> getBrands(@RequestParam ("name")  String name) {
        List<BrandDto> list = brandService.getBrands(name).stream().map(brand -> BrandMapper.INSTANCE.toBrandDto(brand)).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
}
