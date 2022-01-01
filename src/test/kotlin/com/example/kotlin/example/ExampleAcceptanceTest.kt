package com.example.kotlin.example

import com.example.kotlin.AcceptanceTest
import com.example.kotlin.example.ui.ExampleRequest
import com.example.kotlin.example.ui.ExampleResponse
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType

class ExampleAcceptanceTest : AcceptanceTest() {


    @Test
    fun createExampleTest() {
        // given
        val Example_생성_요청값 = Example_생성_요청값_생성("test");

        // when
        val example = Example_생성_요청(Example_생성_요청값);

        // then
        assertThat(example.`as`(ExampleResponse::class.java).name).isEqualTo("test");
    }

    private fun Example_생성_요청값_생성(name: String): ExampleRequest {
        return ExampleRequest(name);
    }

    private fun Example_생성_요청(params: ExampleRequest): ExtractableResponse<Response> {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(params)
                .`when`()
                .post("/examples")
                .then().log().all()
                .extract();
    }
}