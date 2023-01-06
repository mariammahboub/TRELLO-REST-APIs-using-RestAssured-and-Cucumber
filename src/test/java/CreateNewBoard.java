import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class CreateNewBoard {
    public static void main(String[] args) {


        SoftAssert softAssert=new SoftAssert();
        RestAssured.baseURI="https://api.trello.com/1/boards";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key","2e23b24b4529769cd1174f91b5e2441b");
        requestSpecification.queryParam("token","ATTAf03293dead4a9476df761f6e316eb75a0fccb4fbe17e8263e136bb4fd5a590ce5659562C");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body("{  \"name\": \"First TRELLO New REST APIs\"}");
        Response response = requestSpecification.post();
        response.prettyPrint();
        softAssert.assertEquals(response.getStatusCode(),StatusCode.sc_create);
        softAssert.assertAll();
    }


}