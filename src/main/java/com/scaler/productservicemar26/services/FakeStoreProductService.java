package com.scaler.productservicemar26.services;

import com.scaler.productservicemar26.dtos.FakeStoreDto;
import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import com.scaler.productservicemar26.models.Category;
import com.scaler.productservicemar26.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {

        ResponseEntity<FakeStoreDto[]> responseEntity =
                restTemplate.getForEntity(
                        "https://fakestoreapi.com/products/",
                        FakeStoreDto[].class
                );

        List<Product> allProducts = new ArrayList<>();

        FakeStoreDto[] fakeStoreDtos = responseEntity.getBody();
        //for (int i=0; i<responseEntity.getBody().length; i++) {
        for (FakeStoreDto fakeStoreDto : fakeStoreDtos) {
            Product product = convertFakeStoreProductDtoToProduct(fakeStoreDto);
            allProducts.add(product);
        }

        return allProducts;

    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        //make a http call to fake store API to get the product with a given Id
        ResponseEntity<FakeStoreDto> responseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreDto.class
        );

        FakeStoreDto fakeStoreDto = responseEntity.getBody();
        if (fakeStoreDto == null) {
            throw new ProductNotFoundException(productId);
        }

        Product product = convertFakeStoreProductDtoToProduct(fakeStoreDto);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreDto fakeStoreDto) {

        Product product = new Product();
        product.setId(fakeStoreDto.getId());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setDescription(fakeStoreDto.getDescription());
        product.setImageUrl(fakeStoreDto.getImage());
        Category category = new Category();
        category.setTitle(fakeStoreDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
