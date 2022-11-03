package pl.luxoft.qaupskilling.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class SimpleRestAssuredTest {

    @Test
    public void shouldGetListOfUsersFromReqresIn() {
        RestAssured.useRelaxedHTTPSValidation();
        given().
            contentType(ContentType.JSON).params("page","2").
        when().
                get("https://reqres.in/api/users").
        then().
                assertThat().body("data[0].email", is("michael.lawson@reqres.in"));

    }
    @Test
    public void shouldGetListOfUsersFromReqresInExtract() {
        RestAssured.useRelaxedHTTPSValidation();
        String email = given().
            contentType(ContentType.JSON).params("page","2").
        when().
                get("https://reqres.in/api/users").
        then().extract().response().jsonPath().getString("data[0].email");
        System.out.println(email);

    }
}
