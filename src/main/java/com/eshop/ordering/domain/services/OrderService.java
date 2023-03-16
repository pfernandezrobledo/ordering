package com.eshop.ordering.domain.services;

import com.eshop.ordering.domain.entities.Order;

public interface OrderService {
    
    void submitDraftOrder(Order order) throws Exception;

    void getOrderById(Long orderId);

    void getOrdersForCustomer(Long customerId);
}
