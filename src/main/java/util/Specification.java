package util;

import static io.restassured.RestAssured.given;
import static util.Constants.URL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Класс спецификаций тестов
 */
public class Specification {

  /**
   * Создание базовых параметров запроса
   */
  private static RequestSpecification requestSpec() {
    return new RequestSpecBuilder()
        .setBaseUri(URL)
        .setContentType("application/json")
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .build();
  }

  private static RequestSpecification requestSpecHtml() {
    return new RequestSpecBuilder()
        .setBaseUri(URL)
        .setContentType("text/html; charset=utf-8")
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ResponseLoggingFilter())
        .build();
  }

  public static Response doPostRequest(String path, Object body) {
    return given()
        .spec(requestSpec())
        .body(body)
        .when()
        .post(path)
        .thenReturn();
  }

  public static Response doPostRequest(String path, String accessToken, Object body) {
    return given()
        .spec(requestSpec())
        .header("Authorization", accessToken)
        .body(body)
        .when()
        .post(path)
        .thenReturn();
  }

  public static void doDeleteRequest(String path, String accessToken) {
    given()
        .spec(requestSpec())
        .header("Authorization", accessToken)
        .when()
        .delete(path)
        .thenReturn();
  }

  public static Response doPatchRequest(String path, String accessToken, Object body) {
    return given()
        .spec(requestSpec())
        .header("Authorization", accessToken)
        .body(body)
        .when()
        .patch(path)
        .thenReturn();
  }

  public static Response doPatchRequest(String path, Object body) {
    return given()
        .spec(requestSpec())
        .body(body)
        .when()
        .patch(path)
        .thenReturn();
  }

  public static Response doGetRequest(String path, String accessToken, Object body) {
    return given()
        .spec(requestSpecHtml())
        .header("Authorization", accessToken)
        .body(body)
        .when()
        .get(path)
        .thenReturn();
  }
}
