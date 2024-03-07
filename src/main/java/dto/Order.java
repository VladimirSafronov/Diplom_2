package dto;

import java.util.List;

/**
 * Класс dto заказа (список id ингредиентов)
 */
public class Order {

  protected List<String> ingredients;

  public List<String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }
}
