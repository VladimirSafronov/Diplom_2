import static util.Constants.*;

import dto.InfoResponse;
import dto.UserCreatedLoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

public class CreateUserTest extends BaseTest {

  @Test
  @DisplayName("Check created of /auth/register")
  @Description("Пользователя можно создать")
  public void createUserThenSuccess() {
    UserCreatedLoginResponse response = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(UserCreatedLoginResponse.class);

    Assert.assertTrue(response.isSuccess());
    accessToken = response.getAccessToken();
  }

  @Test
  @DisplayName("Check create exists of /auth/register")
  @Description("Нельзя создать существующего пользователя")
  public void createExistsUserThenFail() {
    accessToken = steps.createUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();

    InfoResponse response = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(USER_ALREADY_EXISTS, response.getMessage());
  }

  @Test
  @DisplayName("Check create without field email of /auth/register")
  @Description("Нельзя создать пользователя без поля email")
  public void createUserWithoutEmailThenFail() {
    user.setEmail("");
    InfoResponse response = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(REQUIRED_FIELDS, response.getMessage());
  }

  @Test
  @DisplayName("Check create without field password of /auth/register")
  @Description("Нельзя создать пользователя без поля password")
  public void createUserWithoutPasswordThenFail() {
    user.setPassword("");
    InfoResponse response = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(REQUIRED_FIELDS, response.getMessage());
  }

  @Test
  @DisplayName("Check create without field name of /auth/register")
  @Description("Нельзя создать пользователя без поля name")
  public void createUserWithoutNameThenFail() {
    user.setName("");
    InfoResponse response = steps.createUserStep(user)
        .then()
        .statusCode(HttpStatus.SC_FORBIDDEN)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(REQUIRED_FIELDS, response.getMessage());
  }
}
