package com.scaler.productservicemar26.dtos;

import com.scaler.productservicemar26.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
