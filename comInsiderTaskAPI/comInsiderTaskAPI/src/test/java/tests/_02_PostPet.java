package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojos.CategoryPojo;
import pojos.PetPojo;
import pojos.TagPojo;
import utilities.ConstantsBaseURLInfo;
import utilities.TestBaseReport;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _02_PostPet extends TestBaseReport {

    private RequestSpecification specPetStore;

    @BeforeTest
    public void setup(){
        specPetStore = new RequestSpecBuilder().
                setBaseUri(ConstantsBaseURLInfo.baseUrl +"/pet").
                build();
    }

    @Test
    public void post_Pet_PositiveCase(){
        extentTest = extentReports.createTest("post_pet Positive Api Text");
        // Body olusturulur
        CategoryPojo categoryPojo = new CategoryPojo(71, "Kuş");
        List<TagPojo> tagPojo = List.of(new TagPojo(1, "string"));
        List<String> photoUrls = List.of("string");
        PetPojo petPojo = new PetPojo(987654321,categoryPojo,"Papagan", photoUrls,tagPojo,"pending");

        Response response = given()
                .contentType(ContentType.JSON)
                .spec(specPetStore)
                .body(petPojo)
                .when()
                .post();
        extentTest.info("Post istegi basarili bir sekilde gönderildi.");
        extentTest.info("Response Data : " + response.prettyPrint());
        //response.prettyPrint();

        PetPojo actualData = response.as(PetPojo.class);
        //System.out.println("actualData = " + actualData.toString());

        Assert.assertEquals(petPojo.getId(),actualData.getId());
        Assert.assertEquals(petPojo.getCategory().getId(),actualData.getCategory().getId());
        Assert.assertEquals(petPojo.getCategory().getName(),actualData.getCategory().getName());
        Assert.assertEquals(petPojo.getName(),actualData.getName());
        Assert.assertEquals(petPojo.getPhotoUrls(),actualData.getPhotoUrls());
        Assert.assertEquals(petPojo.getTags().get(0).getId(),actualData.getTags().get(0).getId());
        Assert.assertEquals(petPojo.getTags().get(0).getName(),actualData.getTags().get(0).getName());
        Assert.assertEquals(petPojo.getStatus(),actualData.getStatus());
        extentTest.info("Response body basarili bir sekilde verify edildi");
        extentTest.pass("post_pet Positive Api Test PASSED");

    }

    @Test
    public void post_Pet_NegativeCase(){
        extentTest = extentReports.createTest("post_pet Negative Api Text");
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(specPetStore)
                .body("")
                .when()
                .post();

        //response.prettyPrint();
        extentTest.info("Response status code : " + response.getStatusCode());
        response.then().assertThat()
                .statusCode(405)
                .body("code", equalTo(405)
                        , "type", equalTo("unknown")
                        ,"message", equalTo("no data")
                );
        extentTest.info("Response body basarili bir sekilde verify edildi");
        extentTest.pass("post_pet Negative Api Test PASSED");
    }

}
