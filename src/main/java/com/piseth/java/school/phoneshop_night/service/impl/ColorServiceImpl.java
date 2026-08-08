package com.piseth.java.school.phoneshop_night.service.impl;

import com.piseth.java.school.phoneshop_night.entity.Color;
import com.piseth.java.school.phoneshop_night.exception.ResourceNotFoundException;
import com.piseth.java.school.phoneshop_night.repository.ColorRepository;
import com.piseth.java.school.phoneshop_night.service.ColorService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;
    @Override
    public Color create(Color color) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Color getById(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Color", id));
    }

}