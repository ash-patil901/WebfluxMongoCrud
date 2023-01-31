package com.example.webfluxmongodbcrud.dto;

import com.example.webfluxmongodbcrud.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String id;
    private String name;
    private int qty;
    private double price;

    public Product toModel() {

        return Product.builder()
                .id(this.id)
                .name(this.name)
                .qty(this.qty)
                .price(this.price)
                .build();

    }

}