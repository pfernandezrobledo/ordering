package com.eshop.ordering.domain.repository;

import com.eshop.ordering.domain.entities.Order;

public interface OrderRepository {

    void saveOrder(Order order);

    void getOrderById(Long orderId);

    void getOrdersForCustomer(Long customerId);
}
