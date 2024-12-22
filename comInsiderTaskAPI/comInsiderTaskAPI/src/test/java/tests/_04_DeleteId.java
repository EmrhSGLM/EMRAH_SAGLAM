package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ConstantsBaseURLInfo;
import utilities.TestBaseReport;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _04_DeleteId extends TestBaseReport {

    private RequestSpecification specPetStore;

    @BeforeTest
    public void setup(){
        specPetStore = new RequestSpecBuilder().
                setBaseUri(ConstantsBaseURLInfo.baseUrl +"/pet").
                build();
    }

    @Test
    public void delete_PetId_PositiveCase(){

        extentTest = extentReports.createTest("delete_petid Positive Api Text");
        specPetStore.pathParam("path", 987654321);

        Response response = given()
                .spec(specPetStore)
                .when()
                .delete("/{path}");

        response.prettyPrint();
        response.then().assertThat()
                .statusCode(200)
                .body("code", equalTo(200)
                        , "type", equalTo("unknown")
                        , "message", equalTo("987654321")
                );
        extentTest.info("Response body basarili bir sekilde verify edildi");
        extentTest.pass("delete_petid Positive Api Test PASSED");

    }

    @Test(dependsOnMethods = "delete_PetId_PositiveCase")
    public void delete_PetId_NegativeCase(){
        extentTest = extentReports.createTest("delete_petid Negative Api Text");
        specPetStore.pathParam("path", 909);

        Response response = given()
                .spec(specPetStore)
                .when()
                .delete("/{path}");

        Assert.assertEquals(response.statusCode(),404);
        extentTest.info("Response satus code verify edildi");
        extentTest.pass("delete_petid Negative Api Test PASSED");

    }

}
