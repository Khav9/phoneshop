package com.piseth.java.school.phoneshop_night.controller;

import com.piseth.java.school.phoneshop_night.dto.ProductDTO;
import com.piseth.java.school.phoneshop_night.dto.ProductImportDTO;
import com.piseth.java.school.phoneshop_night.entity.Product;
import com.piseth.java.school.phoneshop_night.mapper.ProductMapper;
import com.piseth.java.school.phoneshop_night.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO ) {
        Product product = productMapper.toProduct(productDTO);
        product = productService.create(product);

        return ResponseEntity.ok(product);
    }

    @PostMapping("importProduct")
    public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO){
        productService.importProduct(importDTO);
        return ResponseEntity.ok().build();
    }
}