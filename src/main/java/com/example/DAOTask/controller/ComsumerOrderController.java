package com.example.DAOTask.controller;

import com.example.DAOTask.model.ConsumerOrder;
import com.example.DAOTask.service.ComsumerOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ComsumerOrderController {
    private final ComsumerOrderService consumer;

    public ComsumerOrderController(ComsumerOrderService consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/fetch-product")
    public String getGetConsumer(@RequestParam("name") String name) {
        return consumer.getProductName(name);
    }
}

