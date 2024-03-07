import dto.GetIngredientsResponse;
import dto.InfoResponse;
import dto.Ingredient;
import dto.Order;
import dto.OrderCreatedAuthResponse;
import dto.OrderCreatedNoAuthResponse;
import dto.UserCreatedLoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import java.util.List;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Constants;

public class CreateOrderTest extends BaseTest {

  private List<Ingredient> allIngredients;
  private Order order;

  @Before
  public void getIngredients() {
    accessToken = steps.createUserStep(user).as(UserCreatedLoginResponse.class).getAccessToken();
    allIngredients = steps.getIngredientsStep(accessToken, user.getEmail()).as(
        GetIngredientsResponse.class).getData();
    order = new Order();
  }

  @Test
  @Description("Check create order with auth of /orders")
  @DisplayName("Проверка создания заказа с авторизацией")
  public void createOrderWithAuthThenSuccess() {
    setIngredients();

    OrderCreatedAuthResponse response = steps.createOrderStep(accessToken, order)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(OrderCreatedAuthResponse.class);

    Assert.assertTrue(response.isSuccess());
    Assert.assertNotNull(response.getOrder().getCreatedAt());
  }

  @Test
  @Description("Check create order without auth of /orders")
  @DisplayName("Проверка создания заказа без авторизации")
  public void createOrderWithoutAuthThenSuccess() {
    setIngredients();

    OrderCreatedNoAuthResponse response = steps.createOrderStep(order)
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract().as(OrderCreatedNoAuthResponse.class);

    Assert.assertTrue(response.isSuccess());
    Assert.assertTrue(response.getOrder().getNumber() > 0);
  }

  @Test
  @Description("Check create order without ingredients of /orders")
  @DisplayName("Проверка создания заказа без ингредиентов")
  public void createOrderWithoutIngredientsThenFail() {

    InfoResponse response = steps.createOrderStep(accessToken, order)
        .then()
        .statusCode(HttpStatus.SC_BAD_REQUEST)
        .extract().as(InfoResponse.class);

    Assert.assertFalse(response.isSuccess());
    Assert.assertEquals(Constants.NO_INGREDIENT, response.getMessage());
  }

  @Test
  @Description("Check create order bad ingredients id of /orders")
  @DisplayName("Проверка создания заказа с неверным хешем ингредиента")
  public void createOrderBadIngredientIdThenFail() {
    order.setIngredients(List.of("badhash"));

    String responseBody = steps.createOrderStep(accessToken, order)
        .then()
        .statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
        .extract()
        .response().getBody().asString();

    Assert.assertTrue(responseBody.contains(Constants.INTERNAL_SERVER_ERROR));
  }

  private void setIngredients() {
    order.setIngredients(List.of(
        allIngredients.get(0).get_id(),
        allIngredients.get(allIngredients.size() - 1).get_id()
    ));
  }
}
