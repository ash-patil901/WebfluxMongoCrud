package com.example.webfluxmongodbcrud.controller;

import com.example.webfluxmongodbcrud.dto.ProductRequest;
import com.example.webfluxmongodbcrud.dto.ProductResponse;
import com.example.webfluxmongodbcrud.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @GetMapping
    public Flux<ProductResponse> getAllProduct(){

        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    public Mono<ProductResponse> getProductById(@PathVariable String id){

        return productService.getProduct(id);
    }

    @PostMapping
    public Mono<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);

    }

    @PutMapping("/update")
    public Mono<ProductResponse> updateProduct(@RequestBody ProductRequest productRequest){
        return productService.updateProduct(productRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productService.deleteProdById(id);
    }


    @GetMapping("/getMapResults")
    private Flux<String> getMap() {
        return productService.transformMap();
    }

    @GetMapping("/getFlatMapResults")
    private Flux<String> getFlatMap() {
        return productService.transformUsingFlatMap();
    }

    @GetMapping("/getMergeResults")
    private Flux<String> getMerge() {
        return productService.merge();
    }

    @GetMapping("/getConcatResults")
    private Flux<String> getConcat() {
        return productService.concat();
    }

    @GetMapping("/getZipResults")
    private Flux<Integer> getZip() {
        return productService.zip();
    }

}
