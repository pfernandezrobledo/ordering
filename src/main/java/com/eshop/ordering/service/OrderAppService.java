package com.eshop.ordering.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.repository.OrderRepository;
import com.eshop.ordering.domain.services.OrderService;

@Service
public class OrderAppService implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderAppService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void submitDraftOrder(Order order) throws Exception{
    
        // Validate that it does have order items
        if(order.getOrderItems().isEmpty()){
            throw new Exception("The order needs to have at least one item.");
        }

        // Set the business state of the order
        order.setOrderDate(LocalDate.now());
        order.setIsDraft(true);
        
        this.repository.saveOrder(order);
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
