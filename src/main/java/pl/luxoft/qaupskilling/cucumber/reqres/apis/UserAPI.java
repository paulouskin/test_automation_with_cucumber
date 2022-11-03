package pl.luxoft.qaupskilling.cucumber.reqres.apis;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.FetchUserDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.FetchUsersDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.UpsertUserRequestDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.model.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserAPI {

    private RequestSpecification req;
    private Response resp;

    private static final String HOST = "https://reqres.in/api/users";

    public UserAPI() {
        req = given().contentType(ContentType.JSON);
    }

    public List<User> getUsers(Integer page) {
        return req.params("page", page).
                when().
                    get(HOST).
                then()
                    .extract()
                    .response()
                    .body()
                    .as(FetchUsersDTO.class).getData();
    }

    public FetchUserDTO getUser(Integer userId) {
        return req.pathParam("userId", userId)
                .when()
                    .get(HOST + "/" + "{userId}")
                .then()
                    .extract().response().as(FetchUserDTO.class);
    }

    public Response createUser(UpsertUserRequestDTO userData) {
        return req.body(userData)
                .when()
                    .post(HOST)
                .then().extract().response();
    }

    public Response updateUser(Integer userId, UpsertUserRequestDTO userData) {
        return req.pathParam("userId", userId)
                .body(userData)
                .when()
                    .put(HOST + "/" + "{userId}")
                .then().extract().response();
    }

    public Response deleteUser(Integer userId) {
        return req.pathParam("userId", userId)
                .when()
                    .delete(HOST + "/" + "{userId}")
                .then().extract().response();
    }
}
