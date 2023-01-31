package com.example.webfluxmongodbcrud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String name;
    private int qty;
    private double price;

}