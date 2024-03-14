import static util.Constants.*;

import dto.InfoResponse;
import dto.UserCreatedLoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginUserTest extends BaseTest {

  @Before
  public void createUser() {
    accessToken = steps.createUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();
  }

  @Test
  @DisplayName("Check login of /auth/login")
  @Description("Успешный логин под существующим пользователем")
  public void loginUserTest() {

    UserCreatedLoginResponse response = steps.loginUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(UserCreatedLoginResponse.class);

    Assert.assertTrue(response.isSuccess());
  }

  @Test
  @DisplayName("Check login incorrect email of /auth/login")
  @Description("Логин с неверным email")
  public void loginIncorrectEmailThenFail() {
    user.setEmail(user.getEmail() + "a");

    InfoResponse response = steps.loginUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(INCORRECT_LOGIN_OR_PASSWORD, response.getMessage());
  }

  @Test
  @DisplayName("Check login incorrect password of /auth/login")
  @Description("Логин с неверным паролем")
  public void loginIncorrectPasswordThenFail() {
    user.setPassword(user.getPassword() + "1");

    InfoResponse response = steps.loginUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(INCORRECT_LOGIN_OR_PASSWORD, response.getMessage());
  }

  @Test
  @DisplayName("Check login without email of /auth/login")
  @Description("Логин без email")
  public void loginNoEmailThenFail() {
    user.setEmail("");

    InfoResponse response = steps.loginUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(INCORRECT_LOGIN_OR_PASSWORD, response.getMessage());
  }

  @Test
  @DisplayName("Check login without password of /auth/login")
  @Description("Логин без пароля")
  public void loginNoPasswordThenFail() {
    user.setPassword("");

    InfoResponse response = steps.loginUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(INCORRECT_LOGIN_OR_PASSWORD, response.getMessage());
  }
}
