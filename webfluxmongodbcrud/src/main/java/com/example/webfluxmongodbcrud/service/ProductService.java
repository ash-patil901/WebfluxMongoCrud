package com.example.webfluxmongodbcrud.service;

import com.example.webfluxmongodbcrud.dto.ProductRequest;
import com.example.webfluxmongodbcrud.dto.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ProductService {
    public Flux<ProductResponse> getProducts();
    public Mono<ProductResponse> getProduct(String id);
    public Mono<ProductResponse> saveProduct(ProductRequest productDtoMono);
    public Mono<ProductResponse> updateProduct(ProductRequest productDtoMono);
    public Mono<Void> deleteProdById(String id);
    public Flux<String> concat();
    public Flux<String> concatWith();
    public Flux<String> merge();
    public Flux<Integer> zip();
    public Flux<String> transformMap();
    public Flux<String> transformUsingFlatMap();


}
