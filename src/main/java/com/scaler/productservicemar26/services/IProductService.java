package com.scaler.productservicemar26.services;

import com.scaler.productservicemar26.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getSingleProduct(Long productId);
    Product createProduct(Product product);
    Product replaceProduct(Long productId, Product product);
}
