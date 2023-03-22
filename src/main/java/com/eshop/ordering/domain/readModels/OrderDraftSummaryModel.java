package com.eshop.ordering.domain.readModels;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDraftSummaryModel {
    
    private Long id;
    private Long customerId;
    private String customerName;
    private Integer itemCount;
    private LocalDate orderDate;
    private Float totalAmount;
}
