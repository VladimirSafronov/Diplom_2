package dto;


import java.util.List;

/**
 * Класс dto созданного заказа
 */
public class CreatedOrder extends BaseCreatedOrder {

  private List<Ingredient> ingredients;
  private Owner owner;
  private int price;

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
