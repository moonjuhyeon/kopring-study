package com.example.kotlin.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExampleTest {

    @Test
    fun createExample() {
        val example = Example.from("name");

        assertThat(example.getName()).isEqualTo("name");
    }
}