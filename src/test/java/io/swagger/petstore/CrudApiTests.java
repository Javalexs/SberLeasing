package io.swagger.petstore;

import dto.RequestBody;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static spec.Specification.requestSpec;
import static spec.Specification.responceSpec200;

public class CrudApiTests {

    Response response;
    @Step ("Создание произвольного пользователя")
    @DisplayName("Создания нового пользователя с параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersCreateTest")
    public void createTest(int id, String userName, String firstName, String lastName, String email, String password, String phone, int status) {

        RequestBody rb = new RequestBody();
        rb.setId(id);
        rb.setUsername(userName);
        rb.setFirstName(firstName);
        rb.setLastName(lastName);
        rb.setEmail(email);
        rb.setPassword(password);
        rb.setPhone(phone);
        rb.setUserStatus(status);

        given()
                .spec(requestSpec())
                .body(rb)
                .when()
                .post("/user")
                .then()
                .log().body()
                .spec(responceSpec200());
    }

    @DisplayName("Изменение данных созданного пользователя с параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersUpdateTest")
    public void updateTest(int id, String userName, String firstName, String lastName, String email, String password, String phone, int status) {
        RequestBody rb = new RequestBody();
        rb.setId(id);
        rb.setUsername(userName);
        rb.setFirstName(firstName);
        rb.setLastName(lastName);
        rb.setEmail(email);
        rb.setPassword(password);
        rb.setPhone(phone);
        rb.setUserStatus(status);

        given()
                .spec(requestSpec())
                .body(rb)
                .when()
                .put("/user/"+ userName)
                .then()
                .log().body()
                .spec(responceSpec200());
    }
    @DisplayName("Получение информации по пользователю с параметром")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersUserName")
    public void getTest(String userName) {
        given()
                .spec(requestSpec())
                .when()
                .get("/user/"+ userName)
                .then()
                .log().body()
                .spec(responceSpec200());
    }
    @DisplayName("Удалить пользователя с параметром")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersUserName")
    public void deleteTest(String userName){
        given()
                .spec(requestSpec())
                .when()
                .delete("/user/"+ userName)
                .then()
                .log().body()
                .spec(responceSpec200());
    }
}
