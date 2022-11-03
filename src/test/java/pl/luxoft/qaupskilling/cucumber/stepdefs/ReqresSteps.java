package pl.luxoft.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.FetchUserDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.FetchUsersDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.model.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    Logger logger = LoggerFactory.getLogger(ReqresSteps.class);

    private Response response;

    @Given("user service is up and running")
    public void user_service_is_up_and_running() {
        logger.info("Checking if User service is up and running");
    }

    @When("we fetch all users from the page {int}")
    public void we_fetch_all_users_from_the_page(Integer page) {
        response = given().
                contentType(ContentType.JSON).params("page", page).
        when().
                get("https://reqres.in/api/users").
        then().log().body()
                .extract().response();
    }

    @Then("user list contains {int} users")
    public void user_list_contains_users(Integer userCount) {
        List<User> users = response
                .body().as(FetchUsersDTO.class).getData();
        Assertions.assertEquals((int) userCount, users.size());
    }

    @When("we fetch the user with id {int}")
    public void we_fetch_the_user_with_id(Integer userId) {
        response = given()
                    .contentType(ContentType.JSON)
                    .pathParam("userId", userId)
                .when()
                    .get("https://reqres.in/api/users/{userId}")
                .then().extract().response();

    }

    @Then("user has an email address {string}")
    public void user_has_an_email_address(String expectedEmail) {
        User michael = response.body().as(FetchUserDTO.class).getData();
        Assertions.assertEquals(expectedEmail, michael.getEmail());

    }
}
