package com.example.webfluxr2dbcsample.services

import com.example.webfluxr2dbcsample.models.Product
import com.example.webfluxr2dbcsample.repositories.CompanyRepository
import com.example.webfluxr2dbcsample.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var companyRepository: CompanyRepository

    fun getAllProducts(): Flux<Product> = productRepository.findAll()

    fun registerNewProduct(productName: String, companyId: Int): Mono<Void> {
        return companyRepository.findById(companyId)
            .flatMap {
                productRepository.save(
                    Product(null, productName, companyId)
                )
            }
            .switchIfEmpty(Mono.error(Exception("company not found")))
            .then()
    }
}
