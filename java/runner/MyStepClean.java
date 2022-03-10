package runner;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInformation;
import helpers.Configuration;
import helpers.JsonAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepClean {
        Response response;
        RequestInformation requestInformation = new RequestInformation();
        Map<String,String> dynamicVar = new HashMap<>();
    @Given("uso autentificacion {}")
    public void usoAutentificacionNone(String auth) {
        String authBasic="Basic "+ Base64.getEncoder().encodeToString((Configuration.user+":"+Configuration.pwd).getBytes());
        System.out.println(authBasic);
        if(auth.equals("basic")){
            requestInformation.setHeaders("Authorization",authBasic);
        }else{
            RequestInformation searchToken = new RequestInformation();
            searchToken.setUrl(Configuration.host+"/api/authentication/token.json");
            searchToken.setHeaders("Authorization",authBasic);
            response= FactoryRequest.make("get").send(searchToken);
            String token = response.then().extract().path("TokenString");
            requestInformation.setHeaders("Token",token);
        }

    }

    @When("uso request {} al enlace {} con el json")
    public void usoRequestPOSTAlEnlaceApiUserJsonConElJson(String request,String url,String body) {
        requestInformation.setUrl(Configuration.host+replaceVar(url))
                .setBody(replaceVar(body));
        response = FactoryRequest.make(request).send(requestInformation);
    }

    @Then("recivo una respuesta {int}")
    public void recivoUnaRespuesta(int expected) {
        response.then().statusCode(expected);
    }

    @And("verifico que el body de respuesta sea")
    public void verificoQueElBodyDeRespuestaSea(String expectedJson) throws Exception {
        JsonAssert.areEqualJson(replaceVar(expectedJson),response.body().asPrettyString(),"Jsons distintos");
    }

    @And("el atributo {} deberia ser {}")
    public void elAtributoFullNameDeberiaSerManuelValenzuelaUpdate(String atributo,String expected) {
        response.then()
                .body(atributo,equalTo(expected));
    }

    private String replaceVar(String value){
        for (String attribute: dynamicVar.keySet() ) {
            value=value.replace(attribute,dynamicVar.get(attribute));
        }
        return value;
    }


    @When("actualizo con el link {} con el usuario {} y password {} con el json")
    public void actualizoConElLinkApiUserJsonConElUsuarioYPassword(String url, String user, String pwd,String body) {
        String authBasic="Basic "+ Base64.getEncoder().encodeToString((user+":"+pwd).getBytes());
        requestInformation.setHeaders("Authorization",authBasic);
        requestInformation.setUrl(Configuration.host+replaceVar(url))
                .setBody(replaceVar(body));
        response = FactoryRequest.make("put").send(requestInformation);
    }


    @And("recivo el {} guardado en {}")
    public void iGetThePropertyIdSaveOnID_PROJECT(String property, String varName) {
        dynamicVar.put(varName,response.then().extract().path(property)+"");

    }
    @When("envio un delete rquest con {} to {}")
    public void iSendADeleteRequestWithTokenIDHeader(String tokenValue, String url) {
        response = given().header("Token", replaceVar(tokenValue)).when().delete(Configuration.host+url);
    }

    @And("guardo el {} de la respuesta en {}")
    public void guardoElIdDeLaRespuestaEnID_PROJ(String attribute,String nameVariable) {
        dynamicVar.put(nameVariable,response.then().extract().path(attribute)+"");
    }
}
