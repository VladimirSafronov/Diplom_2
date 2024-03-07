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
   * Адрес ручки удаления и изменения данных пользователя
   */
  final String deleteAndUpdateUserDataUrl = "/auth/user";

  @Step("Создание пользователя")
  public Response createUserStep(Object body) {
    return doPostRequest(createUserUrl, body);
  }

  @Step("Удаление пользователя")
  public void deleteUserStep(String accessToken) {
    doDeleteRequest(deleteAndUpdateUserDataUrl, accessToken);
  }

  @Step("Логин пользователя")
  public Response loginUserStep(Object body) {
    return doPostRequest(loginUserUrl, body);
  }

  @Step("Обновление данных пользователя")
  public Response updateUserData(String accessToken, Object body) {
    return doPatchRequest(deleteAndUpdateUserDataUrl, accessToken, body);
  }

  @Step("Обновление данных пользователя без Auth")
  public Response updateUserData(Object body) {
    return doPatchRequest(deleteAndUpdateUserDataUrl, body);
  }
}
