package pl.luxoft.qaupskilling.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleRestAssuredTest {

    @Test
    public void shouldGetListOfUsersFromReqresIn() {
        RestAssured.useRelaxedHTTPSValidation();
        given().
            contentType(ContentType.JSON).params("page","2").
        when().
                get("https://reqres.in/api/users").
        then().log().all().
                assertThat().
                statusCode(200);

    }
}
