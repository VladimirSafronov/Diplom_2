package dto;

/**
 * Класс dto ответа работы с данными пользователя
 */
public class BaseUserResponse {

  protected boolean success;
  protected BaseUser user;

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
}
