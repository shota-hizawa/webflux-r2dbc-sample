package com.example.webfluxr2dbcsample.controllers

import com.example.webfluxr2dbcsample.models.Product
import com.example.webfluxr2dbcsample.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    private lateinit var productService: ProductService

    /**
     * 全製品情報を取得する
     */
    @GetMapping
    fun getAllProducts(): Flux<Product> = productService.getAllProducts()

    /**
     * 新しい製品を登録する。
     */
    @PostMapping
    fun registerCompany(@RequestBody registerProductRequest: RegisterProductRequest): Mono<Void> = productService.registerNewProduct(
        registerProductRequest.name,
        registerProductRequest.companyId
    )
}


data class RegisterProductRequest(
    val name: String,
    val companyId: Int
)
