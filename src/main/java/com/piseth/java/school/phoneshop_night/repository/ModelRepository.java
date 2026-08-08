package com.piseth.java.school.phoneshop_night.repository;

import com.piseth.java.school.phoneshop_night.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {

    List<Model> findByBrandId(Long brandId);

}
