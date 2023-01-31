package com.example.webfluxmongodbcrud.respository;
import com.example.webfluxmongodbcrud.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {


    //Flux<ProductDto> findProductBetweenRange(Range<Double> priceRange);
}