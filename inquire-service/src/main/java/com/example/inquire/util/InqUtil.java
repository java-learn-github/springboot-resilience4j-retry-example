package com.example.inquire.util;

import com.example.inquire.model.Product;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class InqUtil {

    @Autowired
    RestTemplate restTemplate;

    public static final String DOWNSTREAM_INTERFACE_CALL = "productservice";

    @Retry(name = DOWNSTREAM_INTERFACE_CALL, fallbackMethod = "callFallBack")
    public List<Product> productByProductService() {
        return restTemplate.getForObject("http://localhost:8086/products", List.class);
    }

    public List<Product> callFallBack(Throwable throwable) {
        log.error(throwable.getMessage());
        log.info("FallBack Method Called");
        List<Product> products = Arrays.asList((new Product(1, "Dummy_product")));
        return products;
    }


}
