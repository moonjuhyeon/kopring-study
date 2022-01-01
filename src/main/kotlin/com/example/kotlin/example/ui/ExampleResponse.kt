package com.example.kotlin.example.ui

import com.example.kotlin.example.domain.Example
import java.time.LocalDateTime

data class ExampleResponse(
        val id: Long,
        val name: String,
        val createdBy: Long,
        val createdDate: LocalDateTime,
        val updatedBy: Long,
        val updatedDate: LocalDateTime
) {

    constructor(example: Example) : this(example.getId(), example.getName(), example.getCreatedBy(), example.getCreatedDate(), example.getUpdatedBy(), example.getUpdatedDate());
}
