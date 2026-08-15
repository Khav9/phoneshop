package com.piseth.java.school.phoneshop_night.repository;

import com.piseth.java.school.phoneshop_night.entity.ProductImportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistory,Long>, JpaSpecificationExecutor<ProductImportHistory> {
}
