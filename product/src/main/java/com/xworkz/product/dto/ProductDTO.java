package com.xworkz.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String type;
    private String cost;
    private String manufacturer;
    private String manufactureDate;
    private int warranty;

}
