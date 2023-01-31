package com.example.webfluxmongodbcrud.utils;


import com.example.webfluxmongodbcrud.dto.ProductRequest;
import com.example.webfluxmongodbcrud.model.Product;
import org.springframework.beans.BeanUtils;


public class AppUtils {


    public static ProductRequest entityToDto(Product product) {
        ProductRequest productDto = new ProductRequest();
     BeanUtils.copyProperties(product,productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductRequest productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
