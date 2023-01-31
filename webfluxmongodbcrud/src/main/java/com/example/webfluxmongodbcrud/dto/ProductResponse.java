package com.example.webfluxmongodbcrud.dto;

import com.example.webfluxmongodbcrud.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private int qty;
    private double price;

    public static ProductResponse fromModel(Product product) {
    return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .qty(product.getQty())
            .price(product.getPrice())
            .build();
    }
}
