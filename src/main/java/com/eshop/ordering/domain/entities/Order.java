package com.eshop.ordering.domain.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //lombok
@NoArgsConstructor  //lombok
@AllArgsConstructor //lombok
// Aggregate Entity/Root
public class Order {
    
    private Long id;
    private Long customerId;
    private List<Product> orderItems;

    // Figure out how to exclude this property from clietn serialization
    private LocalDate orderDate;
    private Boolean isDraft;
}
