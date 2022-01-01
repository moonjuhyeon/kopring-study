package com.example.kotlin.example.ui

import com.example.kotlin.example.domain.Example

data class ExampleRequest(
        val name: String
) {
    fun toEntity(): Example = Example.from(this.name);
}
