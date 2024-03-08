package dto;

import java.util.List;

/**
 * Класс dto приходящего ответа при получении заказов пользователя
 */
public class OrderInfoResponse {

  private boolean success;
  private List<OrderInfo> orders;
  private int total;
  private int totalToday;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<OrderInfo> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderInfo> orders) {
    this.orders = orders;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getTotalToday() {
    return totalToday;
  }

  public void setTotalToday(int totalToday) {
    this.totalToday = totalToday;
  }
}
