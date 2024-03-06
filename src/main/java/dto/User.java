package dto;

/**
 * Класс dto User
 */
public class User extends BaseUser {

  private String password;

  public User() {
  }

  public User(String email, String password, String name) {
    super(email, name);
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
