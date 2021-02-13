package com.example.webfluxr2dbcsample.models

import org.springframework.data.annotation.Id

data class Company(
    @Id
    val id: Int?,
    val name: String
)
