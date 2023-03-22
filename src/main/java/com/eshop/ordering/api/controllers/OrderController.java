package com.eshop.ordering.api.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ordering.domain.entities.Order;
import com.eshop.ordering.domain.readModels.OrderDraftSummaryModel;
import com.eshop.ordering.domain.repository.OrderRepository;
import com.eshop.ordering.domain.services.OrderService;
import com.eshop.ordering.service.commands.SubmitDraftOrderCommand;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {

    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
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


    @PostMapping("/cmd/draft")
    public ResponseEntity<String> submitDraftOrder(@Valid @RequestBody SubmitDraftOrderCommand command) {

        try {
            this.orderService.submitDraftOrder(command);

            //TODO: Return an HTTP 201 withthe ID of the url location where the resource was created

            return new ResponseEntity<String>("Done", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            return new ResponseEntity<String>("Fail", HttpStatusCode.valueOf(500));
        }

    }



    @GetMapping("/draft")
    public ResponseEntity<Collection<Order>> getAllDraftOrders(){

        Collection<Order> orders = this.orderRepository.getAllDraftOrders();

        return ResponseEntity.ok(orders);
    }
    

    @GetMapping("/qry/draft")
    public ResponseEntity<Collection<OrderDraftSummaryModel>> getDraftOrderSummaries(){

        Collection<OrderDraftSummaryModel> orders = this.orderRepository.getDraftOrderSummaries();

        return ResponseEntity.ok(orders);
    }





    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();

        String errorMessage = fieldErrors.get(0).getDefaultMessage();

        return ResponseEntity.badRequest().body(errorMessage);
    }

    
}
