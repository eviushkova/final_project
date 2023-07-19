package org.stepik.tests.api;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.stepik.Auth.Authorization;
import org.stepik.models.CourseModelRequest;
import org.stepik.models.CourseModelResponse;
import org.stepik.specs.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.stepik.Auth.Authorization.authCookieKey;
import static org.stepik.specs.Specs.*;

@Owner("Elena Viushkova")
@Tag("api")
public class CourseTests extends TestBase {

    @Test
    @DisplayName("Check course admission")
    void checkCourseAdmission() {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Make request", () ->
                given(requestSpecification)
                        .headers("Referer", "https://stepik.org/course/127451/promo",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .cookies(cookies)
                        .body(new CourseModelRequest(new CourseModelRequest.Enrollment("127451")))
                        .when()
                        .post("/api/enrollments")
                        .then()
                        .spec(responseSpecStatusCode201)
                        .extract().as(CourseModelResponse.class));
        step("Check response", () -> {
            assertThat(response.getEnrollments()).isNotEmpty();
            assertThat(response.getEnrollments().get(0).getId()).isEqualTo(127451);
        });
    }

    @AfterEach
    void removeCourse() {
        var cookies = Authorization.getAuthCookies(email, password);

        step("Make request", () -> {
            given(requestSpecification)
                    .headers("Referer", "https://stepik.org/learn/courses",
                            "X-Csrftoken", cookies.get(authCookieKey))
                    .cookies(cookies)
                    .when()
                    .delete("/api/enrollments/127451")
                    .then()
                    .spec(responseSpecStatusCode204);
        });
    }

}
