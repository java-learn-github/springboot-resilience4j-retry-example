package com.example.inquire.service;

import com.example.inquire.model.Product;
import com.example.inquire.util.InqUtil;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class InqServiceImpl implements InqService {

    @Autowired
    InqUtil inqUtil;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = inqUtil.productByProductService();
        return products;
    }
}
