package org.stepik.specs;

import com.codeborne.selenide.Configuration;
import org.stepik.config.AppConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
        static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
        public String email = config.getLogin();
        public String password = config.getPassword();

        @BeforeAll
        static void setup() {
            Configuration.baseUrl = config.getBaseUrl();
            RestAssured.baseURI = config.getBaseUrl();
        }
    }

