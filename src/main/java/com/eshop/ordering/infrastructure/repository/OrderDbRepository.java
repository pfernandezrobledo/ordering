package com.eshop.ordering.infrastructure.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.readModels.OrderDraftSummaryModel;
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

    @Override
    public Collection<Order> getAllDraftOrders() {

        return this.dataProvider.getAllOrders();
    }

    @Override
    public Collection<OrderDraftSummaryModel> getDraftOrderSummaries() {

        Collection<Order> orders = this.dataProvider.getAllOrders();

        List<OrderDraftSummaryModel> readModels =

                orders.stream().map(item -> new OrderDraftSummaryModel(
                        item.getId(),
                        item.getCustomerId(),
                        "Customer " + item.getCustomerId(),
                        item.getOrderItems().size(),
                        item.getOrderDate(),
                        item.getTotalAmount())).toList();

        return readModels;
    }

}
