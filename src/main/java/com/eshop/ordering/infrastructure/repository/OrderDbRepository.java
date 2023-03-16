package com.eshop.ordering.infrastructure.repository;

import org.springframework.stereotype.Component;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.repository.OrderRepository;

@Component
public class OrderDbRepository implements OrderRepository{


    
    public OrderDbRepository(){

    }

    @Override
    public void saveOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrder'");
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
