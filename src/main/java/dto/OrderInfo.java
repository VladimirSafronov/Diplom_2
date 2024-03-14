package dto;

import java.util.List;

/**
 * Класс dto содержащий информацию о заказе при получении заказов пользователя
 */
public class OrderInfo extends BaseCreatedOrder {

  private List<String> ingredients;

  public List<String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }
}
