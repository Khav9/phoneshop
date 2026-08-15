package com.piseth.java.school.phoneshop_night.repository;

import com.piseth.java.school.phoneshop_night.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
    List<SaleDetail> findBySaleId(Long saleId);
}
