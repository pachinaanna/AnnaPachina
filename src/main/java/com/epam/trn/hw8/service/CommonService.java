package com.epam.trn.hw8.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.Map;

import static com.epam.trn.hw8.utils.SelectProperties.getTestProperties;
import static io.restassured.RestAssured.given;

public class CommonService {

    private final RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getTestProperties().getProperty("base.url"))
                .build();
    }

    public Response postText(RequestSpecification spec, String uri, String text) {
        Response response = given(spec)
                .queryParam("text", text)
                .post(uri)
                .then().statusCode(Matchers.greaterThanOrEqualTo(HttpStatus.SC_OK))
                .extract().response()
                .then().statusCode(Matchers.lessThan(HttpStatus.SC_MULTIPLE_CHOICES))
                .log().all()
                .extract().response();
        return response;
    }

    public Response postTextWithParams(String uri, String text, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            specification.param(param.getKey(), param.getValue());
        }
        return postText(specification, uri, text);
    }

}
