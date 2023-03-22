package com.eshop.ordering.service.events;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.eshop.ordering.domain.events.OrderDraftCreated;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderDraftCreatedListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void handle(OrderDraftCreated eventObj) {

        ObjectMapper mapper = new ObjectMapper();

        String orderJson;

        try {
            orderJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(eventObj);
            System.out.println(orderJson);

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
