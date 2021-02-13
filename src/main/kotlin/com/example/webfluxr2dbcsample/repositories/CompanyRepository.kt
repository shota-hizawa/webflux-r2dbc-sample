package com.example.webfluxr2dbcsample.repositories

import com.example.webfluxr2dbcsample.models.Company
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CompanyRepository: ReactiveCrudRepository<Company, Int> {
}
