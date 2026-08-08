package com.piseth.java.school.phoneshop_night.service.impl;

import com.piseth.java.school.phoneshop_night.entity.Product;
import com.piseth.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop_night.repository.ProductRepository;
import com.piseth.java.school.phoneshop_night.service.ProductService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        String name = "%s %s"
                .formatted(product.getModel().getName(), product.getColor().getName()) ;
        product.setName(name);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
    }

}