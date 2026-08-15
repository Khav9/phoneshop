package com.piseth.java.school.phoneshop_night.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piseth.java.school.phoneshop_night.dto.SaleDTO;
import com.piseth.java.school.phoneshop_night.service.SaleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("sales")
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SaleDTO saleDTO) {
        saleService.sell(saleDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{saleId}/cancel")
    public ResponseEntity<?> cancelSale(@PathVariable Long saleId){
        saleService.cancelSale(saleId);
        return ResponseEntity.ok().build();
    }

}