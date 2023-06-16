package com.virgin.games.steps;

import com.virgin.games.constants.EndPoints;
import com.virgin.games.model.CurrencyPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CurrencySteps {

    @Step("Getting all information where currency is GBP")
    public ValidatableResponse getUserByGBP() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_CURRENCY_BY)
                .then().log().all();
    }


    @Step("Getting all information where currency is EUR")
    public ValidatableResponse getAllCurrencyEUR(){
        return SerenityRest.given().log().all()
                .when()
                .queryParam("currency","EUR")
                .get(EndPoints.GET_CURRENCY_BY)
                .then().statusCode(200);
    }

    @Step("Getting all information where currency is SEK")
    public ValidatableResponse getAllPotsSEK(){

        return SerenityRest.given().log().all()
                .when()
                .queryParam("currency","SEK")
                .get(EndPoints.GET_CURRENCY_BY)
                .then().statusCode(200);
    }

}
