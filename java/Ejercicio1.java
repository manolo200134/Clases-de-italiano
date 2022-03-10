import helpers.Configuration;
import helpers.JsonAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Ejercicio1 {
    Response response;
    Map<String,String> dynamicVar= new HashMap<>();
    @Given("I have access to Todo.ly")
    public void iHaveAccessToTodoLy() {
    }

    @When("I send a POST petition to {} with json")
    public void iSendAPOSTPetitionToHttpsTodoLyApiUserJsonWithJson(String url, String body) {
        response = given().
                contentType(ContentType.JSON).
                body(body).
                log().all().
                when().post(Configuration.host+url);
    }

    @Then("I recive a {int} response")
    public void iReciveAResponse(int code) {
        response.then().log().all().statusCode(code);
    }

    @And("I check that response has this body")
    public void iCheckThatResponseEmailIsEqualTo(String expected) throws Exception {
        JsonAssert.areEqualJson(replaceVar(expected),response.body().asPrettyString(),"Error jsons distintos");
    }

    @When("I send a PUT request to {} with user {string} and password {string} with json")
    public void iSendAPUTRequestToHttpsTodoLyApiUserJsonWithUserAndPasswordWithJson(String url, String user,String password, String body) {
        response = given().
                auth().
                preemptive().
                basic(user, password).
                contentType(ContentType.JSON).
                body(body).
                log().all().
                when().put(Configuration.host+url);
    }

    @Then("I check a {int} response")
    public void iCheckAResponse(int code) {
        response.then().log().all().statusCode(code);
    }

    @And("I check that response's Full name is {string}")
    public void iCheckThatResponseSFullnameIs(String name) {
        Assertions.assertEquals(name,response.then().extract().path("FullName"));
    }

    private String replaceVar(String value){
        for (String attribute: dynamicVar.keySet() ) {
            value=value.replace(attribute,dynamicVar.get(attribute));
        }
        return value;
    }
}
