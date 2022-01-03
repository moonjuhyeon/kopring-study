package com.example.kotlin.example

import com.example.kotlin.AcceptanceTest
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_목록_조회_요청
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_목록_조회됨
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_생성_요청
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_생성_요청값_생성
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_생성되어_있음
import com.example.kotlin.example.ExampleAcceptanceStaticTest.Example_생성됨
import org.junit.jupiter.api.Test

class ExampleAcceptanceTest : AcceptanceTest() {
    
    @Test
    fun createExampleTest() {
        // given
        val Example_생성_요청값 = Example_생성_요청값_생성("test");

        // when
        val example = Example_생성_요청(Example_생성_요청값);

        // then
        Example_생성됨(example);
    }

    @Test
    fun findByAllTest() {
        // given
        Example_생성되어_있음(Example_생성_요청값_생성("test1"));
        Example_생성되어_있음(Example_생성_요청값_생성("test2"));

        // when
        val response = Example_목록_조회_요청();

        // then
        Example_목록_조회됨(response);
    }
}
