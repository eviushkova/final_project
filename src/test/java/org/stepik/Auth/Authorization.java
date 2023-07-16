package org.stepik.Auth;

import org.stepik.models.LoginBodyModel;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.stepik.helpers.CustomAllureListener.withCustomTemplates;

public class Authorization {

    public static String authCookieKey = "csrftoken";

    public static Map<String, String> getAuthCookies(String email, String password) {

        LoginBodyModel loginBody = new LoginBodyModel(email, password);

        Map<String, String> req = given()
                .when()
                .get("/catalog?auth=login")
                .then()
                .statusCode(200)
                .extract()
                .cookies();

        return given()
                .contentType("application/json")
                .headers("Referer", "https://stepik.org/catalog?auth=login",
                        "X-Csrftoken", req.get(authCookieKey))
                .body(loginBody)
                .cookies(req)
                .log().all()
                .when()
                .post("/api/users/login")
                .then()
                .log().all()
                .statusCode(204)
                .extract()
                .cookies();
    }
}