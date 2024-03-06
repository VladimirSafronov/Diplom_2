package dto;

/**
 * Класс dto ответа успешного создания пользователя
 */
public class UserCreatedResponse {

  private boolean success;
  private BaseUser user;
  private String accessToken;
  private String refreshToken;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public BaseUser getUser() {
    return user;
  }

  public void setUser(BaseUser user) {
    this.user = user;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}
