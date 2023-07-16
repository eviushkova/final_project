package org.stepik.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.stepik.Auth.Authorization;
import org.stepik.specs.TestBase;

import java.io.File;
import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.stepik.Auth.Authorization.authCookieKey;
import static org.stepik.specs.Specs.responseSpecStatusCode200;

@Owner("Elena Viushkova")
@Tag("api")
public class ProfileTests extends TestBase {

    @Test
    @DisplayName("Testing of successful uploading avatar using method PUT")
    void checkUploadAvatarStatus() {

        var cookies = Authorization.getAuthCookies(email, password);

        step("  Check that when loading an avatar the status code is 200", () -> {
            given()
                    .contentType("multipart/form-data")
                    .headers("Referer", "https://stepik.org/catalog?auth=login",
                            "X-Csrftoken", cookies.get(authCookieKey))
                    .multiPart(new File("src/test/resources/testAvatar.png"))
                    .cookies(cookies)
                    .when()
                    .put("api/profile-images/38659455")
                    .then()
                    .spec(responseSpecStatusCode200);
        });
    }
}
