package com.piseth.java.school.phoneshop_night.controller;

import com.piseth.java.school.phoneshop_night.dto.ModelDto;
import com.piseth.java.school.phoneshop_night.entity.Model;
import com.piseth.java.school.phoneshop_night.mapper.ModelMapper;
import com.piseth.java.school.phoneshop_night.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService  modelService;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ModelDto modelDto) {
        Model model = modelMapper.toModel(modelDto);
        model = modelService.save(model);
        //convert to dto
        return ResponseEntity.ok(modelMapper.toModelDto(model));
    }
}
