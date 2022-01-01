package com.example.kotlin.example.ui

import com.example.kotlin.example.application.ExampleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/examples")
@RestController
class ExampleController(
        val exampleService: ExampleService
) {

    @PostMapping
    fun saveExample(
            @RequestBody exampleRequest: ExampleRequest
    ): ResponseEntity<Any> {
        val example = exampleService.save(exampleRequest);
        return ResponseEntity.created(URI.create("/" + example.id))
                .body(example);
    }

}