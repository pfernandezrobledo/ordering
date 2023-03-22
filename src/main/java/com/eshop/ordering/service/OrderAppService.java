package com.eshop.ordering.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.entities.Product;
import com.eshop.ordering.domain.repository.OrderRepository;
import com.eshop.ordering.domain.services.OrderService;
import com.eshop.ordering.service.commands.SubmitDraftOrderCommand;

@Service
public class OrderAppService implements OrderService {

    private OrderRepository repository;

    @Autowired
    public OrderAppService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void submitDraftOrder(Order order) throws Exception {

        // Validate that it does have order items
        if (order.getOrderItems().isEmpty()) {
            throw new Exception("The order needs to have at least one item.");
        }

        // Set the business state of the order
        // The aggregate/entity should be responsible for setting it's own business
        // state when possible

        // order.setOrderDate(LocalDate.now());
        // order.setIsDraft(true);

        order.calculateTotal();

        this.repository.saveOrder(order);
    }

    @Override
    public Order submitDraftOrder(SubmitDraftOrderCommand command) throws Exception {

        // Validate that it does have order items
        if (command.getOrderItems().isEmpty()) {
            throw new Exception("The order needs to have at least one item.");
        }

        // Build the aggregate from the command

        List<Product> products = command.getOrderItems().stream().map(item ->
        new Product(123L,
                item.getManufacturer(),
                item.getProductName(),
                item.getUnitPrice())).toList();

        Order order = new Order(command.getCustomerId(), products);



        this.repository.saveOrder(order);

        return order;
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
