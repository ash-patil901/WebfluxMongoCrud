package com.example.webfluxmongodbcrud.service;

import com.example.webfluxmongodbcrud.Exception.CustomException;
import com.example.webfluxmongodbcrud.dto.ProductRequest;
import com.example.webfluxmongodbcrud.dto.ProductResponse;

import com.example.webfluxmongodbcrud.model.Product;
import com.example.webfluxmongodbcrud.respository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements  ProductService {
    @Autowired
    ProductRepository productRepository;


    public Flux<ProductResponse> getProducts(){
         return  productRepository.findAll().map(ProductResponse::fromModel);
    }

    public Mono<ProductResponse> getProduct(String id){
        return productRepository.findById(id)
                .map(ProductResponse::fromModel)
                .switchIfEmpty(Mono.error(new CustomException(
                        "Product not found with id :" + id)));
    }

    public Mono<ProductResponse> saveProduct(ProductRequest productRequest){
      return Mono.just(productRequest)
              .map(ProductRequest::toModel)
                .flatMap(product-> productRepository.save(product))
                .map(ProductResponse::fromModel)
                .onErrorReturn(ProductResponse.builder().build());

    }
    public Mono<ProductResponse> updateProduct(ProductRequest productRequest) {

        return Mono.just(productRequest)
                .map(ProductRequest::toModel)
                .flatMap(product-> productRepository.save(product))
                .map(ProductResponse::fromModel)
                .onErrorReturn(ProductResponse.builder().build());

    }

    public Mono<Void> deleteProdById(String id){
    if(id.isEmpty()){
        throw new CustomException("Product not found with id :" + id);
    }
    else{
        return productRepository.deleteById(id);
    }
    }

    public Flux<String> concat() {
        Flux<String> flux1 = Flux.just(" {1} ","{2} ","{3} ","{4} " );
        Flux<String> flux2 = Flux.just(" |A|"," |B| "," |C| ");

        Flux<String> result = Flux.concat(flux1, flux2).log();
        return result;
    }

    public Flux<String> concatWith() {
        Flux<String> flux1 = Flux.just(" {1} ","{2} ","{3} ","{4} " );
        Flux<String> flux2 = Flux.just(" |A|"," |B| "," |C| ");

        Flux<String> result = flux1.concatWith(flux2).log();
        return result;
    }

    public Flux<String> merge() {
        Flux<String> flux1 = Flux.just(" {1} ","{2} ","{3} ","{4} " );
        Flux<String> flux2 = Flux.just(" |A|"," |B| "," |C| ");

        Flux<String> result = Flux.merge(flux1, flux2).log();
        return result;
    }

    public Flux<Integer> zip(){

        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4,5,6);
        Flux<Integer> result = Flux.zip(flux1,flux2,(n1, n2)->{
            return n1*n2;
        });
        return result;
    }

    public Flux<String> transformMap() {
        List<String> names = Arrays.asList("google", "facebook", "Stackoverflow");
        Flux<String> mapNames = Flux.fromIterable(names).filter(name -> name.length() > 5).map(n -> n.toUpperCase())
                .log();
        return mapNames;

    }

    public Flux<String> transformUsingFlatMap() {
        List<String> names = Arrays.asList("google ", "abc", "fb", " stackoverflow");
        Flux<String> names$ = Flux.fromIterable(names).filter(name -> name.length() > 5).flatMap(name -> {
            return Mono.just(name.toUpperCase());
        });
        return names$;
    }




}
