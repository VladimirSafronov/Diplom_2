package dto;

public class BaseUser {

  protected String email;
  protected String name;

  public BaseUser() {
  }

  public BaseUser(String email, String name) {
    this.email = email.toLowerCase();
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
