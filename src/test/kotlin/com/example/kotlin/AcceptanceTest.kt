package com.example.kotlin

import com.example.kotlin.util.DatabaseCleanUp
import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class AcceptanceTest {

    @LocalServerPort
    val port: Int = 0;

    @Autowired
    private val databaseCleanUp: DatabaseCleanUp = DatabaseCleanUp();

    @BeforeEach
    fun setUp() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
            databaseCleanUp.afterPropertiesSet();
        }

        databaseCleanUp.execute();
    }
}
