package com.eshop.ordering.infrastructure.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eshop.ordering.domain.entities.Order;

@Component
public class OrderDbMemDataProvider {

    private Map<Long, Order> orderMap = new HashMap<Long, Order>();

    public void saveOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    public Collection<Order> getAllOrders(){
        
        return orderMap.values();
    }
}
