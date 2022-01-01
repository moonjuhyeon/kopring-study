package com.example.kotlin.example.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ExampleRepository : JpaRepository<Example, Long> {
}