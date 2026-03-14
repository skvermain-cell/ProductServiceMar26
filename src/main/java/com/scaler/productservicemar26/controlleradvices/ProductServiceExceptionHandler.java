package com.scaler.productservicemar26.controlleradvices;

import com.scaler.productservicemar26.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException) {

        return new ResponseEntity<>(
                productNotFoundException.getProductId() + " is not a valid Product Id. Please use a valid one!",
                HttpStatus.INTERNAL_SERVER_ERROR
        );

    }
}
