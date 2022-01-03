package com.example.kotlin.example.ui

import com.example.kotlin.example.domain.Example
import java.time.LocalDateTime
import java.util.stream.Collectors

data class ExampleResponse(
    val id: Long,
    val name: String,
    val createdDate: LocalDateTime,
    val updatedDate: LocalDateTime
) {
    constructor(example: Example) : this(
        example.getId(),
        example.getName(),
        example.getCreatedDate(),
        example.getUpdatedDate()
    );

    companion object {
        fun ofList(examples: List<Example>): List<ExampleResponse> {
            return examples.stream()
                .map { ExampleResponse(it) }
                .collect(Collectors.toList());
        }
    }
}
