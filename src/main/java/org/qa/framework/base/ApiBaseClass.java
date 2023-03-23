package org.qa.framework.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.qa.framework.utilities.CommonUtils;

@Slf4j
public class ApiBaseClass {
    public RequestSpecification getRequestSpecs(){
        CommonUtils.setEnv("qa");
        return RestAssured
                .with()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .log()
                .all(true);
    }
}
