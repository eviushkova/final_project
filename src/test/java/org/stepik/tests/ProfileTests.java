package org.stepik.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.stepik.auth.Authorization;
import org.stepik.models.*;
import org.stepik.models.LanguageModelRequest.Language;
import org.stepik.specs.TestBase;

import java.io.File;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.stepik.auth.Authorization.authCookieKey;
import static org.stepik.models.LanguageModelRequest.Language.*;
import static org.stepik.specs.Specs.*;

@Owner("Elena Viushkova")
@Tag("api")
public class ProfileTests extends TestBase {

    @Test
    @DisplayName("Check of successful uploading avatar using PUT method")
    void checkUploadAvatarStatus() {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Make request", () ->
                given(requestUploadAvatarSpec)
                        .headers("Referer", "https://stepik.org/catalog?auth=login",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .multiPart("avatar", new File("src/test/resources/cat.jpeg"))
                        .cookies(cookies)
                        .when()
                        .put("/api/profile-images/38659455")
                        .then()
                        .spec(responseSpecStatusCode200)
                        .extract().as(AvatarModelResponse.class));
        step("Check that avatar is not empty", () -> {
            assertThat(response.getProfileImages()).isNotEmpty();
            assertThat(response.getProfileImages().get(0).getAvatar()).isNotEmpty();
        });
    }

    @Test
    @DisplayName("Check avatar removal")
    void checkAvatarRemoval() {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Check that when loading an avatar the status code is 200", () ->
                given(requestAvatarRemoval)
                        .headers("Referer", "https://stepik.org/catalog?auth=login",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .cookies(cookies)
                        .body(new AvatarModelRequest(""))
                        .when()
                        .put("/api/profile-images/38659455")
                        .then()
                        .spec(responseSpecStatusCode200)
                        .extract().as(AvatarModelResponse.class));
        step("Check that avatar removed", () -> {
            assertThat(response.getProfileImages()).isNotEmpty();
            assertThat(response.getProfileImages().get(0).getAvatar()).isNull();
        });
    }

    @Test
    @DisplayName("Check for the existence of a certificate using GET method")
    void checkCertificateExist() {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Check that if there is a course certificate 1128, the status code is 200", () ->
                given(requestCheckCertificate)
                        .headers("Referer", "https://stepik.org/catalog?auth=login",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .cookies(cookies)
                        .when()
                        .get("/api/certificates/1676278")
                        .then()
                        .spec(responseSpecStatusCode200)
                        .extract().as(CertificateModelResponse.class));
        step("Check response", () -> {
            assertThat(response.getCertificates()).isNotEmpty();
            assertThat(response.getCertificates().get(0)).satisfies(certificate -> {
                assertThat(certificate.getId()).isEqualTo(1676278);
                assertThat(certificate.getUser()).isEqualTo(38659455);
            });
        });
    }

    @ParameterizedTest
    @MethodSource("languages")
    @DisplayName("Check language change")
    void checkLanguageChange(Language language) {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Check that if there is a course certificate 1128, the status code is 200", () ->
                given(requestChangeLang)
                        .headers("Referer", "https://stepik.org/catalog?auth=login",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .cookies(cookies)
                        .body(new LanguageModelRequest(new Profile(language)))
                        .when()
                        .put("/api/profiles/38659455")
                        .then()
                        .spec(responseSpecStatusCode200)
                        .extract().as(LanguageModelResponse.class));
        step("Check response", () -> {
            assertThat(response.getProfiles()).isNotEmpty();
            assertThat(response.getProfiles().get(0).getLanguage()).isEqualTo(language);
        });
    }

    private static Stream<Language> languages() {
        return Stream.of(PORTUGUESE, ENGLISH, RUSSIAN);
    }
}
