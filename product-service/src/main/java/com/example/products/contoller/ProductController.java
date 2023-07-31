package com.example.products.contoller;

import com.example.products.model.Product;
import com.example.products.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        List<Product> allProducts = service.getAllProducts();
        return allProducts;
    }
}
