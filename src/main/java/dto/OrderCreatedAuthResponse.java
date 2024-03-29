package dto;

/**
 * Класс dto созданного заказа авторизованным пользователем
 */
public class OrderCreatedAuthResponse extends BaseOrderCreatedResponse {

  private CreatedOrder order;

  public CreatedOrder getOrder() {
    return order;
  }

  public void setOrder(CreatedOrder order) {
    this.order = order;
  }
}
