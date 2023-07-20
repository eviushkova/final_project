package org.stepik.specs;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.stepik.config.AppConfig;

public class TestBase {
    static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());

    public String email = System.getProperty("email", config.getLogin());
    public String password = System.getProperty("password", config.getPassword());

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = System.getProperty("baseUrl", config.getBaseUrl());
    }
}
