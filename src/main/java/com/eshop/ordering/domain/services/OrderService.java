package com.eshop.ordering.domain.services;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.service.commands.SubmitDraftOrderCommand;

public interface OrderService {
    
    void submitDraftOrder(Order order) throws Exception;

    Order submitDraftOrder(SubmitDraftOrderCommand command) throws Exception;

    void getOrderById(Long orderId);

    void getOrdersForCustomer(Long customerId);
}
