package pl.luxoft.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.luxoft.qaupskilling.cucumber.reqres.apis.UserAPI;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.FetchUserDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.PostUserResponseDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.dto.UpsertUserRequestDTO;
import pl.luxoft.qaupskilling.cucumber.reqres.model.User;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReqresSteps {

    Logger logger = LoggerFactory.getLogger(ReqresSteps.class);

    private Response response;
    private RequestSpecification request;

    private List<User> users;
    private FetchUserDTO getUserResponse;
    private PostUserResponseDTO createUserResponse;
    private UserAPI userAPI;

    @Given("user service is up and running")
    public void user_service_is_up_and_running() {
        logger.info("Checking if User service is up and running");
    }

    @Given("I configure request appropriately")
    public void iConfigureRequestAppropriately() {
        logger.info("Configuring request to be sent");
        userAPI = new UserAPI();
        request = given()
                    .contentType(ContentType.JSON)
                    .header("ourHeader", "ourHeaderValue")
                    .cookies("ourHomemadeCookies", "cookie1=value1");
    }

    @When("we fetch all users from the page {int}")
    public void we_fetch_all_users_from_the_page(Integer page) {
        users = userAPI.getUsers(page);
        /*response =
                request.params("page", page).
        when().
                get("https://reqres.in/api/users").
        then().log().body()
                .extract().response();*/
    }

    @Then("user list contains {int} users")
    public void user_list_contains_users(Integer userCount) {
        /*List<User> users = response
                .body().as(FetchUsersDTO.class).getData();*/
        Assertions.assertEquals((int) userCount, users.size());
    }

    @When("we fetch the user with id {int}")
    public void we_fetch_the_user_with_id(Integer userId) {
        getUserResponse = userAPI.getUser(userId);
        /*response = request.pathParam("userId", userId)
                .when().get("https://reqres.in/api/users/{userId}")
                .then().extract().response();*/
    }

    @Then("user has an email address {string}")
    public void user_has_an_email_address(String expectedEmail) {
        User michael = getUserResponse.getData();
        //User michael = response.body().as(FetchUserDTO.class).getData();
        Assertions.assertEquals(expectedEmail, michael.getEmail());
    }

    @When("we create new user with the following parameters:")
    public void we_create_new_user_with_the_following_parameters(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps();
        UpsertUserRequestDTO userData = getPostUserRequestDTOFromMap(users.get(0));
        response = userAPI.createUser(userData);
       /* response = request
                    .body(userData)
                    //.body(users.get(0))
                .when()
                    .post("https://reqres.in/api/users")
                .then().extract().response();*/
    }

    private UpsertUserRequestDTO getPostUserRequestDTOFromMap(Map<String, String> userAsMap) {
        return new UpsertUserRequestDTO(userAsMap.get("name"), userAsMap.get("job") );
    }

    @Then("user {string} is returned")
    public void user_id_is_returned(String param) {
        String expectedParameter = response.jsonPath().getString(param);
        Assertions.assertNotNull(expectedParameter);
    }

    @When("we update the user with id {int} with following information:")
    public void we_update_the_user_with_id_with_following_information(Integer userId, io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps();
        UpsertUserRequestDTO userData = getPostUserRequestDTOFromMap(users.get(0));
        response = userAPI.updateUser(userId, userData);
                        /*request
                    .pathParam("userId", userId)
                    .body(userData)
                .when()
                    .put("https://reqres.in/api/users/{userId}")
                .then().extract().response();*/
    }

    @When("we delete the user with id {int}")
    public void we_delete_the_user_with_id(Integer userId) {
        response = userAPI.deleteUser(userId);
                    /*request
                    .pathParam("userId", userId)
                .when()
                    .delete("https://reqres.in/api/users/{userId}")
                .then()
                .extract().response();*/
    }

    @Then("operation completed successfully")
    public void operation_completed_successfully() {
        int statusCode = response.statusCode();
        Assertions.assertEquals(204, statusCode);
    }


}
