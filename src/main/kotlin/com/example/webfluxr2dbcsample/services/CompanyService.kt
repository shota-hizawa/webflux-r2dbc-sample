package com.example.webfluxr2dbcsample.services

import com.example.webfluxr2dbcsample.models.Company
import com.example.webfluxr2dbcsample.repositories.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CompanyService {
    @Autowired
    private lateinit var companyRepository: CompanyRepository

    fun getAllCompanies(): Flux<Company> = companyRepository.findAll()

    fun registerNewCompany(name: String): Mono<Void> = companyRepository.save(
        Company(
            null,
            name
        )
    )
        .then()
}
