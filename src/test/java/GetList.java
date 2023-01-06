import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;

public class GetList {
    public static void main(String[] args) {


   SoftAssert softAssert=new SoftAssert();
        RestAssured.baseURI="https://api.trello.com";
        RestAssured.basePath="/1/boards/56fQKbUP/lists";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("key","2e23b24b4529769cd1174f91b5e2441b");
        requestSpecification.queryParam("token","ATTAf03293dead4a9476df761f6e316eb75a0fccb4fbe17e8263e136bb4fd5a590ce5659562C");
        requestSpecification.header("Content-Type","application/json");
        Response response = requestSpecification.get();
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        softAssert.assertEquals(jsonPath.get("[0].name"),"First List TRELLO New REST APIs");
        softAssert.assertEquals(jsonPath.get("[0].id"),"63b4dbb1edb8010233b0f79e");
        softAssert.assertEquals(response.getStatusCode(),StatusCode.sc_get);
        softAssert.assertAll();

}
}
