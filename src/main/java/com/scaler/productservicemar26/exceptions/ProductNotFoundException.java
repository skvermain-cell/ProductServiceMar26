package com.scaler.productservicemar26.exceptions;

public class ProductNotFoundException extends RuntimeException {

    private Long productId;

    public ProductNotFoundException(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }



}
