package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setContentType("application/json")
                .build();
    }
    public static ResponseSpecification responceSpec200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responceSpec400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();
    }
}
