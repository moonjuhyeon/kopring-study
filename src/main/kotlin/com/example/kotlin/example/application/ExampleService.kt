package com.example.kotlin.example.application

import com.example.kotlin.example.domain.ExampleRepository
import com.example.kotlin.example.ui.ExampleRequest
import com.example.kotlin.example.ui.ExampleResponse
import org.springframework.stereotype.Service

@Service
class ExampleService(
        val exampleRepository: ExampleRepository
) {
    fun save(exampleRequest: ExampleRequest): ExampleResponse {
        return ExampleResponse(exampleRepository.save(exampleRequest.toEntity()));
    }


}