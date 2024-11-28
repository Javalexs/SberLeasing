package io.swagger.petstore;

import dto.RequestBody;
import dto.ResponseGetBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static spec.Specification.requestSpec;
import static spec.Specification.responseSpec;

/**
 * Класс тестов для "https://petstore.swagger.io/"
 */
public class CrudApiTests {

    //Переменная класса тела запроса
    private static RequestBody rb = new RequestBody();

    @DisplayName("Создание нового пользователя с параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersCreateTest")
    public void createTest(int id, String userName, String firstName, String lastName, String email, String password, String phone, int status) {
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
                .spec(responseSpec());

    }

    @DisplayName("Изменение данных созданного пользователя с параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersUpdateTest")
    public void updateTest(int id, String userName, String firstName, String lastName, String email, String password, String phone, int status) {
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
                .spec(responseSpec());
    }

    @DisplayName("Получение информации по пользователю с параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersUpdateTest")
    public void getTest(int id, String userName, String firstName, String lastName, String email, String password, String phone, int status) {
        ResponseGetBody respGet = given()
                .spec(requestSpec())
                .when()
                .get("/user/"+ userName)
                .then()
                .log().body()
                .statusCode(200)
                .extract().body().as(ResponseGetBody.class);

        String notEqual = " в теле запроса не совпадает с ожидаемым";
        assertAll(
                () -> assertEquals(respGet.getId(), id, "Идентификатор" + notEqual),
                () -> assertEquals(respGet.getUsername(), userName, "Логин пользователя" + notEqual),
                () -> assertEquals(respGet.getFirstName(), firstName, "Имя пользователя" + notEqual),
                () -> assertEquals(respGet.getLastName(), lastName, "Фамилия пользователя" + notEqual),
                () -> assertEquals(respGet.getEmail(), email, "Электронная почта" + notEqual),
                () -> assertEquals(respGet.getPassword(), password, "Пароль пользователя" + notEqual),
                () -> assertEquals(respGet.getPhone(), phone, "Номер телефона пользователя" + notEqual),
                () -> assertEquals(respGet.getUserStatus(), status, "Статус" + notEqual)
        );
    }
    @DisplayName("Удаление пользователя с параметром")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("helpers.DataProvider#providerParametersDeleteTest")
    public void deleteTest(String userName){
        given()
                .spec(requestSpec())
                .when()
                .delete("/user/"+ userName)
                .then()
                .log().body()
                .spec(responseSpec());
    }
}
