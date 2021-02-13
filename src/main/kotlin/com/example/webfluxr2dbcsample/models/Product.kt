package com.example.webfluxr2dbcsample.models

import org.springframework.data.annotation.Id

data class Product (
    @Id
    val id: Int?,
    val name: String,
    val company_id: Int
    )
