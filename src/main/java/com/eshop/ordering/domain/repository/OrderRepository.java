package com.eshop.ordering.domain.repository;

import java.util.Collection;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.readModels.OrderDraftSummaryModel;

public interface OrderRepository {

    void saveOrder(Order order);

    Collection<Order> getAllDraftOrders();

    Collection<OrderDraftSummaryModel> getDraftOrderSummaries();

    void getOrderById(Long orderId);

    void getOrdersForCustomer(Long customerId);
}
