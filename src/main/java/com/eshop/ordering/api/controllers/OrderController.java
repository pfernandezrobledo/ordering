package com.eshop.ordering.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.services.OrderService;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/draft")
    public ResponseEntity<String> submitDraftOrder(@RequestBody Order order) {

        try {
            //TODO: Validate the entity

            this.orderService.submitDraftOrder(order);

            //TODO: Return an HTTP 201 withthe ID of the url location where the resource was created

            return new ResponseEntity<String>("Done", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            return new ResponseEntity<String>("Fail", HttpStatusCode.valueOf(500));
        }

    }
}
