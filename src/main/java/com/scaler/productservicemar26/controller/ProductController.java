package com.scaler.productservicemar26.controller;

import com.scaler.productservicemar26.models.Product;
import com.scaler.productservicemar26.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService prodSvc;

    public ProductController(IProductService prodSvc){
        this.prodSvc = prodSvc;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) {

        return prodSvc.getSingleProduct(productId);

    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return new ArrayList<>();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,
                          @RequestBody Product product) {

        return null;
    }
}
