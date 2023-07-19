package org.stepik.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.stepik.helpers.CustomAllureListener.withCustomTemplates;


public class Specs {

    public static RequestSpecification requestUploadAvatarSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("multipart/form-data");
    public static ResponseSpecification responseSpecStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification requestAvatarRemoval = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/json");

    public static RequestSpecification requestCheckCertificate = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/json");

    public static RequestSpecification requestChangeLang = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/json; charset=utf-8");

    public static RequestSpecification requestAddToWishList = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/json; charset=utf-8");

    public static ResponseSpecification responseSpecStatusCode201 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static RequestSpecification requestSpecification = with()
            .log().uri()
            .log().method()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/json; charset=utf-8");

    public static ResponseSpecification responseSpecStatusCode204 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(204)
            .build();


}
