package com.example.kotlin.example

import com.example.kotlin.example.ui.ExampleRequest
import com.example.kotlin.example.ui.ExampleResponse
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.assertj.core.api.Assertions.assertThat
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

object ExampleAcceptanceStaticTest {

    private val EXAMPLE_PATH: String = "/examples";

    fun Example_생성_요청값_생성(name: String): ExampleRequest {
        return ExampleRequest(name);
    }

    fun Example_생성_요청(params: ExampleRequest): ExtractableResponse<Response> {
        return RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(params)
            .`when`()
            .post(EXAMPLE_PATH)
            .then().log().all()
            .extract();
    }

    fun Example_생성됨(response: ExtractableResponse<Response>) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    fun Example_생성되어_있음(params: ExampleRequest): ExampleResponse {
        return Example_생성_요청(params).`as`(ExampleResponse::class.java)
    }

    fun Example_목록_조회_요청(): ExtractableResponse<Response> {
        return RestAssured.given().log().all()
            .`when`()
            .get(EXAMPLE_PATH)
            .then().log().all()
            .extract();
    }

    fun Example_목록_조회됨(response: ExtractableResponse<Response>) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value())
    }
}
