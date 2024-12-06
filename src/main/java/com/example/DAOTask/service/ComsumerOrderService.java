package com.example.DAOTask.service;

import com.example.DAOTask.repository.ConsumerOrderRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
public class ComsumerOrderService {
    private final ConsumerOrderRepository consumerOrderRepository;

    public ComsumerOrderService(ConsumerOrderRepository consumerOrderRepository) {
        this.consumerOrderRepository = consumerOrderRepository;
    }

    public String getProductName(String name) {
        return consumerOrderRepository.getProductName(name);
    }

}
