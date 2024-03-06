package util;

import static util.Constants.URL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
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
}
