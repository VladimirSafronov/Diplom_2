import static util.Specification.*;

import io.qameta.allure.Step;
import io.restassured.response.Response;

/**
 * Класс со степами
 */
public class Steps {

  /**
   * Адрес ручки создания пользователя
   */
  final String createUserUrl = "/auth/register";

  /**
   * Адрес ручки логина пользователя
   */
  final String loginUserUrl = "/auth/login";

  /**
   * Адрес ручки удаления пользователя
   */
  final String deleteUserUrl = "/auth/user";

  @Step("Создание пользователя")
  public Response createUserStep(Object body) {
    return doPostRequest(createUserUrl, body);
  }

  @Step("Удаление пользователя")
  public void deleteUserStep(String accessToken) {
    doDeleteRequest(deleteUserUrl, accessToken);
  }

  @Step("Логин пользователя")
  public Response loginUserStep(Object body) {
    return doPostRequest(loginUserUrl, body);
  }
}
