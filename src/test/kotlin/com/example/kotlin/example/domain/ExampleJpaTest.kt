package com.example.kotlin.example.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ExampleJpaTest @Autowired constructor(
        val exampleRepository: ExampleRepository
) {

    @Test
    fun saveTest() {
        val example = Example.from("test");

        val expectExample = exampleRepository.save(example);

        assertThat(expectExample.getId()).isEqualTo(1L);
        assertThat(expectExample.getName()).isEqualTo(example.getName());
    }
}