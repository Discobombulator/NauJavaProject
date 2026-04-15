package ru.Yaroslav.NauJava;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RegistrationControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void shouldRegisterUser() {
        given()
                .param("username", "test")
                .param("password", "123")
                .when()
                .post("/registration")
                .then()
                .statusCode(302);
    }

    @Test
    void shouldHandleEmptyInput() {
        given()
                .when()
                .post("/registration")
                .then()
                .statusCode(200);
    }

}
