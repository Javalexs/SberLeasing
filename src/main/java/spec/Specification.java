package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.isA;

public class Specification {
    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/")
                .setContentType("application/json")
                .build();
    }

    public static ResponseSpecification responseSpec(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("code", isA(Integer.class))
                .expectBody("type", isA(String.class))
                .expectBody("message", isA(String.class))
                .build();
    }
}
