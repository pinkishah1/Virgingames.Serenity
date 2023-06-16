package com.virgin.games.testbase;

import com.virgin.games.constants.Path;
import com.virgin.games.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static java.lang.Integer.parseInt;

public class TestBase  {

    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.BINGOPATH;
    }
}
