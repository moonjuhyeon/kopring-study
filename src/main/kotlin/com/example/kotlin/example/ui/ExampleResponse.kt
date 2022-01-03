package com.example.kotlin.example.ui

import com.example.kotlin.example.domain.Example
import java.time.LocalDate
import java.time.LocalDateTime

data class ExampleResponse(
        val id: Long,
        val name: String,
        val createdDate: LocalDateTime,
        val updatedDate: LocalDateTime
) {
    constructor(example: Example) : this(example.getId(), example.getName(), example.getCreatedDate(), example.getUpdatedDate());
}
