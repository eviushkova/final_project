package org.stepik.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.stepik.Auth.Authorization;
import org.stepik.models.WishListModelRequest;
import org.stepik.models.WishListModelRequest.WishList;
import org.stepik.models.WishListModelResponse;
import org.stepik.specs.TestBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.stepik.Auth.Authorization.authCookieKey;
import static org.stepik.specs.Specs.*;

@Owner("Elena Viushkova")
@Tag("api")
public class WishListTests extends TestBase {

    @Test
    @DisplayName("Check if the course has been added to the wishlist")
    void checkAddCourseToWishList() {

        var cookies = Authorization.getAuthCookies(email, password);

        var response = step("Make request", () ->
                given(requestAddToWishList)
                        .headers("Referer", "https://stepik.org/course/124803/promo?auth=login",
                                "X-Csrftoken", cookies.get(authCookieKey))
                        .cookies(cookies)
                        .body(new WishListModelRequest(new WishList("124803")))
                        .when()
                        .post("/api/wish-lists")
                        .then()
                        .spec(responseSpecStatusCode201)
                        .extract().as(WishListModelResponse.class));
        step("Check response", () -> {
            assertThat(response.getWishLists()).isNotEmpty();
            assertThat(response.getWishLists().get(0)).satisfies(wishList -> {
                assertThat(wishList.getCourse()).isEqualTo(124803);
                assertThat(wishList.getId()).isNotNull();

                removeWishList(wishList.getId());
            });
        });
    }

    void removeWishList(long wishListId) {
        var cookies = Authorization.getAuthCookies(email, password);

        step("Make request", () -> {
            given(requestSpecification)
                    .headers("Referer", "https://stepik.org/learn/courses/wishlist",
                            "X-Csrftoken", cookies.get(authCookieKey))
                    .cookies(cookies)
                    .when()
                    .delete("/api/wish-lists/" + wishListId)
                    .then()
                    .spec(responseSpecStatusCode204);
        });
    }
}
