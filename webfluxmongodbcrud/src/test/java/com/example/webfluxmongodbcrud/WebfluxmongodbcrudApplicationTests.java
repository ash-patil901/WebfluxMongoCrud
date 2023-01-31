package com.example.webfluxmongodbcrud;

import com.example.webfluxmongodbcrud.controller.ProductController;
import com.example.webfluxmongodbcrud.dto.ProductRequest;
import com.example.webfluxmongodbcrud.dto.ProductResponse;
import com.example.webfluxmongodbcrud.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@WebFluxTest(ProductController.class)
class WebfluxmongodbcrudApplicationTests {

	@Test
	void contextLoads() {
	}

	/*@MockBean
	ProductServiceImpl productService;

	@Autowired
	WebTestClient webTestClient;

	public void addProductTest(){
		ProductRequest productRequest =Mono.just(new ProductResponse("102","mobile",1,10000));
		when(productService.saveProduct(productRequest)).thenReturn(productRequest);

		webTestClient.post().uri("/products")
				.body(Mono.just(productRequest), ProductRequest.class)
				.exchange()
				.expectStatus().isOk();//200

	}


	@Test
	public void getProductsTest(){
		ProductRequest productDtoFlux= Flux.just(new ProductRequest("102","mobile",1,10000),
				new ProductRequest("103","TV",1,50000));
		when(productService.getProducts()).thenReturn(productDtoFlux);

		Flux<ProductRequest> responseBody = webTestClient.get().uri("/products")
				.exchange()
				.expectStatus().isOk()
				.returnResult(ProductRequest.class)
				.getResponseBody();

		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNext(new ProductRequest("102","mobile",1,10000))
				.expectNext(new ProductRequest("103","TV",1,50000))
				.verifyComplete();

	}


	@Test
	public void getProductTest(){
		Mono<ProductRequest> productDtoMono=Mono.just(new ProductRequest("102","mobile",1,10000));
		when(productService.getProduct(any())).thenReturn(productDtoMono);

		Flux<ProductRequest> responseBody = webTestClient.get().uri("/products/product/102")
				.exchange()
				.expectStatus().isOk()
				.returnResult(ProductRequest.class)
				.getResponseBody();

		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNextMatches(p->p.getName().equals("mobile"))
				.verifyComplete();
	}


	@Test
	public void updateProductTest(){
		Mono<ProductRequest> productDtoMono=Mono.just(new ProductRequest("102","mobile",1,10000));
		when(productService.updateProduct(productDtoMono,"102")).thenReturn(productDtoMono);

		webTestClient.put().uri("/products/update/102")
				.body(Mono.just(productDtoMono), ProductRequest.class)
				.exchange()
				.expectStatus().isOk();//200
	}

	@Test
	public void deleteProductTest(){
		given(productService.deleteProdById(any())).willReturn(Mono.empty());
		webTestClient.delete().uri("/products/delete/102")
				.exchange()
				.expectStatus().isOk();//200
	}
*/
}
