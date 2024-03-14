package util;

import com.github.javafaker.Faker;

/**
 * Класс с константами
 */
public class Constants {

  static Faker faker = new Faker();

  /**
   * Базовый url приложения
   */
  public static final String URL = "https://stellarburgers.nomoreparties.site/api";

  /**
   * Ожидаемое соообщение при попытке создания существующего пользователя
   */
  public static final String USER_ALREADY_EXISTS = "User already exists";

  /**
   * Ожидаемое соообщение при попытке создания пользователя без обязательного поля
   */
  public static final String REQUIRED_FIELDS = "Email, password and name are required fields";

  /**
   * Ожидаемое соообщение при попытке логина пользователя без обязательного поля или с ошибкой в нем
   */
  public static final String INCORRECT_LOGIN_OR_PASSWORD = "email or password are incorrect";

  /**
   * Ожидаемое соообщение при попытке манипуляций без авторизации
   */
  public static final String SHOULD_AUTHORIZED = "You should be authorised";

  /**
   * Ожидаемое соообщение при попытке изменения на существующий email
   */
  public static final String EMAIL_ALREADY_EXISTS = "User with such email already exists";

  /**
   * Ожидаемое соообщение при попытке создания заказа не указав ингридиентов
   */
  public static final String NO_INGREDIENT = "Ingredient ids must be provided";

  /**
   * Содержание в теле ответа при статус коде 500
   */
  public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

  /**
   * Данные для тестового пользователя
   */
  public static final String TEST_USER_EMAIL = faker.internet().emailAddress();
  public static final String TEST_USER_PASSWORD = faker.internet().password(6, 10);
  public static final String TEST_USER_NAME = faker.name().firstName();
}
