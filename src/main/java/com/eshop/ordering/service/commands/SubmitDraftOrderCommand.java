package com.eshop.ordering.service.commands;

import java.util.List;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor
@AllArgsConstructor // lombok
public class SubmitDraftOrderCommand {
    @NotNull(message = "the customer id should not be null")
    private Long customerId;
    @NotEmpty(message = "the order items ahould not be empty")
    private List<OrderItemCommand> orderItems;
}
