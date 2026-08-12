package com.piseth.java.school.phoneshop_night.repository;

import com.piseth.java.school.phoneshop_night.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Optional<Product> findByModelIdAndColorId(Long modelId, Long colorId);
}
