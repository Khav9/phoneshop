package com.piseth.java.school.phoneshop_night.service;

import com.piseth.java.school.phoneshop_night.dto.ProductReportDTO;
import com.piseth.java.school.phoneshop_night.dto.report.ExpenseReportDTO;
import com.piseth.java.school.phoneshop_night.projection.ProductSold;

import java.time.LocalDate;
import java.util.List;

public interface ReportService {
    List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate);

    List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate);

    List<ExpenseReportDTO> getExpenseReport(LocalDate startDate, LocalDate endDate);
}
