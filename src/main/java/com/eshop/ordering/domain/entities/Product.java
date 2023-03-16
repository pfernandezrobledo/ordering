package com.eshop.ordering.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //lombok
@NoArgsConstructor  //lombok
@AllArgsConstructor //lombok
// Entity
public class Product {
    private Long id;
    private String manufacturer;
    private String productName;
    private Float unitPrice;
}
