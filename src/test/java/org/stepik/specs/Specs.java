package org.stepik.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.stepik.helpers.CustomAllureListener.withCustomTemplates;


public class Specs {

    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=utf-8");
    public static ResponseSpecification responseSpecStatusCode200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
