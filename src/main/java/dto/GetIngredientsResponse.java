package dto;

import java.util.List;

/**
 * Класс dto ответа получения списка ингредиентов
 */
public class GetIngredientsResponse {

  private boolean success;
  private List<Ingredient> data;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<Ingredient> getData() {
    return data;
  }

  public void setData(List<Ingredient> data) {
    this.data = data;
  }
}
