package com.eshop.ordering.infrastructure.repository;

import org.springframework.stereotype.Component;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.repository.OrderRepository;

@Component
public class OrderDbRepository implements OrderRepository {

    private OrderDbMemDataProvider dataProvider;

    public OrderDbRepository(OrderDbMemDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void saveOrder(Order order) {
        // MAp to a DTO object
        
        this.dataProvider.saveOrder(order);
    }

    @Override
    public void getOrderById(Long orderId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }

    @Override
    public void getOrdersForCustomer(Long customerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrdersForCustomer'");
    }

}
