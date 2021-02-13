package com.example.webfluxr2dbcsample.repositories

import com.example.webfluxr2dbcsample.models.Product
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository: ReactiveCrudRepository<Product, Int> {
}
