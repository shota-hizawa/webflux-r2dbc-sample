package com.example.webfluxr2dbcsample

import com.example.webfluxr2dbcsample.models.Company
import com.example.webfluxr2dbcsample.models.Product
import com.example.webfluxr2dbcsample.repositories.CompanyRepository
import com.example.webfluxr2dbcsample.repositories.ProductRepository
import com.example.webfluxr2dbcsample.services.ProductService
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@SpringBootTest
@DisplayName("ProductServiceのテスト")
class ProductServiceTests {

    val productRepository = mock<ProductRepository> {
        on { findAll() } doReturn Flux.just(
            Product(1, "iPhone", 1),
            Product(2, "MacBook Pro", 1),
            Product(3, "Pixel5", 2)
        )
        on { save(any()) } doReturn Mono.just(Product(1, "Dummy Product", 1))
    }

    val companyRepository = mock<CompanyRepository> {
        on { findAll() } doReturn Flux.just(
            Company(1, "Apple"),
            Company(2, "Google"),
        )
        on { findById(1) } doReturn Mono.just(Company(1, "Apple"))
        on { findById(2) } doReturn Mono.just(Company(2, "Google"))
        on { findById(3) } doReturn Mono.empty()
    }

    @InjectMocks
    private lateinit var productService: ProductService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Nested
    @DisplayName("参照テスト")
    inner class GetTests {
        @Test
        fun `正常系 すべての製品情報を取得する`() {
            // test
            val result = productService.getAllProducts()
            StepVerifier.create(result)
                .expectNext(Product(1, "iPhone", 1))
                .expectNext(Product(2, "MacBook Pro", 1))
                .expectNext(Product(3, "Pixel5", 2))
                .expectComplete()
                .verify()
        }
    }

    @Nested
    @DisplayName("登録テスト")
    inner class RegisterTests {
        @Test
        fun `正常系 登録に成功する`() {
            val result = productService.registerNewProduct("iPhone", 1)
            StepVerifier.create(result)
                .expectNext()
                .expectComplete()
                .verify()
        }

        @Test
        fun `異常系 存在しないcompanyIdがリクエストされていた場合登録に失敗する`() {
            val result = productService.registerNewProduct("SurfaceBook", 3)
            StepVerifier.create(result)
                .expectErrorMatches { error -> error.message === "company not found" }
                .verify()
        }
    }

}
