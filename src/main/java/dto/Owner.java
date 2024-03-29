package dto;

/**
 * Класс dto пользователя, сделавшего заказ
 */
public class Owner extends BaseUser {

  private String createdAt;
  private String updatedAt;

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
