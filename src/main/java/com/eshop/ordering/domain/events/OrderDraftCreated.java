package com.eshop.ordering.domain.events;

import java.time.LocalDate;

import com.eshop.ordering.domain.entities.Order;

import lombok.Data;

@Data
public class OrderDraftCreated {
    
    private Long eventId;
    private LocalDate eventDate;
    private Long orderId;

    private Order order;

    public OrderDraftCreated(Order order){

        this.eventId = 0L;
        this.eventDate = LocalDate.now();
        this.orderId = order.getId();

        this.order = order;
    }
}
