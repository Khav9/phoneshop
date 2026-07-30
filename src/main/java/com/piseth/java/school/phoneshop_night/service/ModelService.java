package com.piseth.java.school.phoneshop_night.service;

import com.piseth.java.school.phoneshop_night.dto.ModelDto;
import com.piseth.java.school.phoneshop_night.entity.Model;

import java.util.List;

public interface ModelService {
    Model save(Model model);

    List<Model> findByBrandId(Integer brandId);
}
