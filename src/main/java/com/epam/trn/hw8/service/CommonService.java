package com.epam.trn.hw8.service;

import static io.restassured.RestAssured.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import java.util.Map;
import java.util.Properties;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;

    @SneakyThrows
    private Properties getProperties() {
        Properties props = new Properties();
        String propFileName = "test.properties";
        props.load(getClass().getClassLoader().getResourceAsStream(propFileName));
        return props;
    }

    public CommonService() {
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getProperties().getProperty("base.url"))
                .build();
    }

    public Response postTextNoParams(String uri, String text) {
        Response response = given(REQUEST_SPECIFICATION)
                .queryParam("text", text)
                .post(uri);
        response.then().statusCode(Matchers.greaterThanOrEqualTo(HttpStatus.SC_OK));
        response.then().statusCode(Matchers.lessThan(HttpStatus.SC_MULTIPLE_CHOICES));
        response.then().log().all();
        return response;
    }

    public Response postTextWithParams(String uri, String text, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for(Map.Entry<String, Object> param : params.entrySet()) {
            specification.param(param.getKey(), param.getValue());
        }
        Response response = specification.queryParams("text", text)
                .post(uri);
        response.then().log().all();
        return response;
    }

}
