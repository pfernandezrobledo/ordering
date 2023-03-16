package com.eshop.ordering.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               //lombok
@NoArgsConstructor  //lombok
@AllArgsConstructor //lombok
// Entity
public class Customer {
    private Long id;
    private String customerName;
    private String customerAddress;
    private String creditCard;
}
