import dto.GetIngredientsResponse;
import dto.InfoResponse;
import dto.Ingredient;
import dto.Order;
import dto.OrderInfoResponse;
import dto.UserCreatedLoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import java.util.List;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Constants;

public class GetUserOrdersTest extends BaseTest {

  @Before
  public void initTestData() {
    accessToken = steps.createUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();

    List<Ingredient> allIngredients = steps.getIngredientsStep(accessToken, user.getEmail()).as(
        GetIngredientsResponse.class).getData();

    Order order = new Order();
    order.setIngredients(List.of(allIngredients.get(0).get_id()));
    steps.createOrderStep(order);
  }

  @Test
  @Description("Check get orders auth user of /orders")
  @DisplayName("Получение заказов авторизованного пользователя")
  public void getOrdersAuthUserThenSuccess() {
    OrderInfoResponse response = steps.getUserOrders(accessToken)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(OrderInfoResponse.class);

    Assert.assertTrue(response.isSuccess());
  }

  @Test
  @Description("Check get orders noAuth user of /orders")
  @DisplayName("Получение заказов неавторизованного пользователя")
  public void getOrdersNoAuthUserThenFail() {
    InfoResponse response = steps.getUserOrders()
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(Constants.SHOULD_AUTHORIZED, response.getMessage());
  }
}
