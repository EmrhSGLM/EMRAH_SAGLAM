package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Constants;
import utilities.ConstantsBaseURLInfo;
import utilities.TestBaseReport;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _01_GetPetId extends TestBaseReport {

    private RequestSpecification specPetStore;

    @BeforeTest
    public void setup(){
        specPetStore = new RequestSpecBuilder().
                setBaseUri(ConstantsBaseURLInfo.baseUrl +"/pet").
                build();
    }

    @Test
    public void getPetId_PositiveScenario(){
        extentTest = extentReports.createTest("get_petid Positive Api Test");
        specPetStore.pathParam("path", Constants.positiveSenario_PetId);

        Response response = given()
                .spec(specPetStore)
                .when()
                .get("/{path}");
        response.prettyPrint();
        extentTest.info("Response data : " + response.prettyPrint());
        response.then().assertThat()
                .statusCode(200)
                .body("id", equalTo(Constants.positiveSenario_PetId),
                        "category.id", equalTo(71),
                        "category.name", equalTo("Kuş"),
                        "name", equalTo("Papagan"),
                        "tags[0].id", equalTo(1),
                        "tags[0].name", equalTo("string"),
                        "status", equalTo("pending")
                );
        extentTest.info("response basarili bir şekilde verify edildi.");
        extentTest.pass("get_petid Positive Api Test PASSED");

    }

    @Test
    public void getPetId_NegativeScenario(){
        extentTest = extentReports.createTest("get_petid Negative Api Test");
        specPetStore.pathParam("path", Constants.negativeSenario_PetId);

        Response response = given()
                .spec(specPetStore)
                .when()
                .get("/{path}");

        response.then().assertThat().statusCode(404);
        Assert.assertTrue(response.asString().contains("Not Found"));
        extentTest.pass("get_petid Negative Api Test PASSED");

    }

}
