package com.virgin.games.crudtest;
import com.virgin.games.steps.CurrencySteps;
import com.virgin.games.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.hasItem;

@RunWith(SerenityRunner.class)
public class GETTest extends TestBase {
    @Steps
    CurrencySteps currencySteps;

    static ValidatableResponse response;
    @Title("Getting all pots information where currency is GBP.")
    @Test
    public void test001() {
        response = currencySteps.getUserByGBP();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("GBP"));
    }
    @Title("Getting all information where currency is EUR")
    @Test
    public void test002() {
        response = currencySteps.getAllCurrencyEUR();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("EUR"));
    }

    @Title("Getting all information where currency is SEK")
    @Test
    public void getAllInformationSEK(){
        response= currencySteps.getAllPotsSEK();
        response.log().all().statusCode(200);
        response.body("data.pots.currency", hasItem("SEK"));
    }
}
