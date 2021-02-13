package com.example.webfluxr2dbcsample.controllers

import com.example.webfluxr2dbcsample.models.Company
import com.example.webfluxr2dbcsample.services.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/company")
class CompanyController {
    @Autowired
    private lateinit var companyService: CompanyService

    /**
     * 全企業情報を取得する
     */
    @GetMapping
    fun getAllCompany(): Flux<Company> = companyService.getAllCompanies()

    /**
     * 新しい企業を登録する。
     */
    @PostMapping
    fun registerCompany(@RequestBody registerCompanyRequest: RegisterCompanyRequest): Mono<Void> = companyService.registerNewCompany(registerCompanyRequest.name)
}


data class RegisterCompanyRequest(
    val name: String
)
