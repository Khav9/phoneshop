package com.piseth.java.school.phoneshop_night.service;

import com.piseth.java.school.phoneshop_night.dto.SaleDTO;
import com.piseth.java.school.phoneshop_night.entity.Sale;

public interface SaleService {
    void sell(SaleDTO saleDTO);

    Sale getById(Long saleId);
    void cancelSale(Long saleId);
}