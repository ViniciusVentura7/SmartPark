package br.com.smartpark.api;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;

public class ParkingSpotApiTest {

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.basePath = "/api/vagas";
    }

    @Test
    public void deveCadastrarParkingSpotComSucesso() {
        given()
                .contentType("application/json")
                .body("""
                {
                  "endereco": "Av. Brasil, 100",
                  "latitude": -23.55,
                  "longitude": -46.63
                }
            """)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("disponivel", equalTo(true));
    }

    @Test
    public void deveListarParkingSpots() {
        when()
                .get()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void deveRetornarErroParaParkingSpotInexistente() {
        when()
                .get("/9999")
                .then()
                .statusCode(500)
                .body(containsString("Vaga não encontrada"));
    }


    @Test
    public void contratoRespostaDeveSerValido() {
        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("parking-spot.schema.json"));
    }
}
