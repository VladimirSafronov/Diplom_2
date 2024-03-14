import static util.Constants.*;

import dto.BaseUser;
import dto.BaseUserResponse;
import dto.InfoResponse;
import dto.User;
import dto.UserCreatedLoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateUserDataTest extends BaseTest {

  @Before
  public void initTestData() {
    accessToken = steps.createUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();
  }

  @Test
  @Description("Check update email from authorization user of /auth/user")
  @DisplayName("Проверка изменения данных email авторизованного пользователя")
  public void updateAuthUserEmailThenSuccess() {
    accessToken = steps.loginUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();

    BaseUser updatedUser = updatedData(user, user.getEmail() + "a");
    BaseUserResponse response = steps.updateUserData(accessToken, updatedUser)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(BaseUserResponse.class);

    Assert.assertEquals(updatedUser.getEmail(), response.getUser().getEmail());
  }

  @Test
  @Description("Check update name from authorization user of /auth/user")
  @DisplayName("Проверка изменения данных name авторизованного пользователя")
  public void updateAuthUserNameThenSuccess() {
    accessToken = steps.loginUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();

    BaseUser updatedUser = updatedData(user, user.getName() + "a");
    BaseUserResponse response = steps.updateUserData(accessToken, updatedUser)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(BaseUserResponse.class);

    Assert.assertEquals(updatedUser.getName(), response.getUser().getName());
  }

  @Test
  @Description("Check update all fields from authorization user of /auth/user")
  @DisplayName("Проверка изменения всех данных авторизованного пользователя")
  public void updateAuthUserAllDataThenSuccess() {
    accessToken = steps.loginUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();

    BaseUser updatedUser = updatedData(user, user.getEmail() + "z", user.getName() + "a");
    BaseUserResponse response = steps.updateUserData(accessToken, updatedUser)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(BaseUserResponse.class);

    Assert.assertEquals(updatedUser.getEmail(), response.getUser().getEmail());
    Assert.assertEquals(updatedUser.getName(), response.getUser().getName());
  }

  @Test
  @Description("Check fail exists email from authorization user of /auth/user")
  @DisplayName("Проверка ошибки изменения на существующий email авторизованного пользователя")
  public void updateAuthUserExistsEmailThenFail() {
    accessToken = steps.loginUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();
    User secondUser = new User(TEST_USER_EMAIL + "b", TEST_USER_PASSWORD + "b",
        TEST_USER_NAME + "b");
    UserCreatedLoginResponse secondUserResponse = steps.createUserStep(secondUser).as(
        UserCreatedLoginResponse.class);

    BaseUser updatedUser = updatedData(user, secondUser.getEmail());
    InfoResponse response = steps.updateUserData(accessToken, updatedUser)
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(EMAIL_ALREADY_EXISTS, response.getMessage());

    steps.deleteUserStep(secondUserResponse.getAccessToken());
  }

  @Test
  @Description("Check update email from nonAuth user of /auth/user")
  @DisplayName("Проверка изменения данных email неавторизованного пользователя")
  public void updateEmailNoAuthUserThenFail() {
    BaseUser updUser = updatedData(user, user.getEmail() + "a");
    InfoResponse response = steps.updateUserData(updUser)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(SHOULD_AUTHORIZED, response.getMessage());
  }

  @Test
  @Description("Check update name from nonAuth user of /auth/user")
  @DisplayName("Проверка изменения данных name неавторизованного пользователя")
  public void updateNameNoAuthUserThenFail() {
    BaseUser updUser = updatedData(user, user.getName() + "a");
    InfoResponse response = steps.updateUserData(updUser)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(SHOULD_AUTHORIZED, response.getMessage());
  }

  /**
   * Метод обновляет переданные данные у пользователя
   */
  private BaseUser updatedData(BaseUser user, String... data) {
    for (String d : data) {
      if (d.contains("@")) {
        user.setEmail(d);
      } else {
        user.setName(d);
      }
    }
    return user;
  }
}
