package dto;

/**
 * Класс dto ответа успешного создания заказа незарегистрированного пользователя
 */
public class OrderCreatedNoAuthResponse extends BaseOrderCreated {

  private OrderNumber order;

  public OrderNumber getOrder() {
    return order;
  }

  public void setOrder(OrderNumber order) {
    this.order = order;
  }
}
