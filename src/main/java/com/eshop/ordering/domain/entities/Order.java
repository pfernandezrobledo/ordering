package com.eshop.ordering.domain.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@AllArgsConstructor // lombok
// Aggregate Entity/Root
public class Order {

    private Long id;
    private Long customerId;
    private List<Product> orderItems;

    // Figure out how to exclude this property from clietn serialization
    private LocalDate orderDate;
    private Boolean isDraft;
    private Float totalAmount;

    public Order(Long customerId, List<Product> orderItems) {
        this.customerId = customerId;
        this.orderItems = orderItems;

        this.orderDate = LocalDate.now();
        this.isDraft = true;
        
        this.calculateTotal();
    }


    public Order(){
        this.setOrderDate(LocalDate.now());
        this.setIsDraft(true);
    }


    public void calculateTotal() {

        Float total = 0.0f;

        for (Product product : orderItems) {
            total += product.getUnitPrice();
        }

    }
}
