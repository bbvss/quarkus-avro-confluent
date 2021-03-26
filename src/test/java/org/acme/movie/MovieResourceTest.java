package org.acme.movie;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class MovieResourceTest {

    @Test
    void testMovieEndpoint() {
        given()
                .when().get("/movies")
                .then()
                .statusCode(200)
                .body(is("hello quarkus movies!")); // Modified line
    }

}
