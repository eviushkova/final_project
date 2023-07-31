package org.stepik.auth;

import org.stepik.models.LoginModel;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authorization {

    public static String authCookieKey = "csrftoken";

    public static Map<String, String> getAuthCookies(String email, String password) {

        LoginModel loginBody = new LoginModel(email, password);

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
                .when()
                .post("/api/users/login")
                .then()
                .statusCode(204)
                .extract()
                .cookies();
    }
}