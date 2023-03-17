package com.eshop.ordering.service.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor
@AllArgsConstructor // lombok
public class OrderItemCommand {
    private Long id;
    private String manufacturer;
    private String productName;
    private Float unitPrice;
}
