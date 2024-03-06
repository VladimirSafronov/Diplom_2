package util;

/**
 * Класс с константами
 */
public class Constants {

  /**
   * Базовый url приложения
   */
  public static final String URL = "https://stellarburgers.nomoreparties.site/api";

  /**
   * Заголовок при ответе с кодом 200
   */
  public static final String OK_STATUS_LINE = "HTTP/1.1 200 OK";

  /**
   * Ожидаемое соообщение при попытке создания существующего пользователя
   */
  public static final String USER_ALREADY_EXISTS = "User already exists";

  /**
   * Ожидаемое соообщение при попытке создания пользователя без обязательного поля
   */
  public static final String REQUIRED_FIELDS = "Email, password and name are required fields";


  /**
   * Данные для тестового пользователя
   */
  public static final String TEST_USER_EMAIL = "testUser9898@yandex.ru";
  public static final String TEST_USER_PASSWORD = "pass9898";
  public static final String TEST_USER_NAME = "testUser9898";
}
