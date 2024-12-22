package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testData.PetStoreData;
import utilities.Constants;
import utilities.ConstantsBaseURLInfo;
import utilities.TestBaseReport;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class _01_GetFindByStatus extends TestBaseReport {

    private RequestSpecification specPetStore;

    @BeforeTest
    public void setup(){
        specPetStore = new RequestSpecBuilder().
                setBaseUri(ConstantsBaseURLInfo.baseUrl +"/pet").
                build();
    }


    @Test
    public void test01_findByStatus_Available_Positive(){
        extentTest = extentReports.createTest("FindByStatus endpointi status=avaliable positive test ");
        specPetStore.pathParam("path","findByStatus");

        PetStoreData expectedObje = new PetStoreData();
        HashMap<String, Object> expectedData = expectedObje.setupTestData();

        Response response = given().
                spec(specPetStore).
                queryParam("status", Constants.available).
                when().
                get("/{path}");

        //response.prettyPrint();

        // Json Path ile verify islemi
        JsonPath json = response.jsonPath();


        Assert.assertEquals(((Map) expectedData.get("sixthPet")).get("id"),
                json.getLong("[5].id"));
        Assert.assertEquals(((Map) expectedData.get("sixthPet")).get("category_id"),
                json.getInt("[5].category.id"));
        Assert.assertEquals(((Map) expectedData.get("sixthPet")).get("category_name"),
                json.getString("[5].category.name"));
        Assert.assertEquals(((Map) expectedData.get("sixthPet")).get("name"),
                json.getString("[5].name"));
        Assert.assertEquals(((Map) expectedData.get("sixthPet")).get("tags_id"),
                json.getInt("[5].tags[0].id"));
        Assert.assertEquals(expectedData.get("once_pet_id"),
                json.getLong("[0].id"));
        Assert.assertEquals(expectedData.get("second_name"),
                json.getString("[1].name"));
        Assert.assertEquals(expectedData.get("fifth_name"),
                json.getString("[4].name"));

        extentTest.pass("FindByStatus endpointi status=avaliable positive API Test PASSED");

    }

    @Test
    public void test02_findByStatus_Available_Positive_Negative(){
        extentTest = extentReports.createTest("FindByStatus endpointi status=avaliable negative test ");
        specPetStore.pathParam("path","findByStatus");

        Response response = given().
                spec(specPetStore).
                queryParam("status", "x").
                //queryParam("status", Constants.available).
                when().
                get("/{path}");

        response.prettyPrint();
        String str = response.asString();
        response.then().assertThat()
                .statusCode(200);
        Assert.assertFalse(str.contains("id"));
        Assert.assertFalse(str.contains("category"));
        Assert.assertFalse(str.contains("name"));
        extentTest.pass("FindByStatus endpointi status=avaliable negative API Test PASSED");
    }


    @Test
    public void test03_findByStatus_Pending_Positive(){
        specPetStore.pathParam("path","findByStatus");

        Response response = given().
                spec(specPetStore).
                queryParam("status", Constants.pending).
                when().
                get("/{path}");

        response.prettyPrint();
    }

    @Test
    public void test05_findByStatus_Sold_Positive(){
        specPetStore.pathParam("path","findByStatus");

        Response response = given().
                spec(specPetStore).
                queryParam("status", Constants.sold).
                when().
                get("/{path}");

        response.prettyPrint();
    }


}
