package com.virgin.games.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(SerenityRunner.class)
public class UserExtractionGBPTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots/bingo";
        response = given().
                when().
                get("").
                then().statusCode(200);
    }

    @Title("Extract the limit")
    @Test
    public void test01() {
        List<HashMap<String,?>> sizeofData = response.extract().path("data.pots.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + sizeofData.size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Title("Verify the first id equal to 194")
    @Test
    public void test02() {
        response.body("data.pots[0].id", anything("194"));
    }

}
