import static util.Constants.TEST_USER_EMAIL;
import static util.Constants.TEST_USER_NAME;
import static util.Constants.TEST_USER_PASSWORD;

import dto.User;
import org.junit.After;
import org.junit.Before;

/**
 * Базовый тестовый класс, содержащий общие для всех тестов поля и методы инициализации и удаления
 * тестовых данных
 */
public class BaseTest {

  protected final Steps steps = new Steps();
  protected User user;
  protected String accessToken;

  /**
   * Метод создает пользователя для теста
   */
  @Before
  public void setTestData() {
    user = new User(TEST_USER_EMAIL, TEST_USER_PASSWORD, TEST_USER_NAME);
  }

  /**
   * Метод удаляет пользователя если он был создан
   */
  @After
  public void cleanTestData() {
    if (accessToken != null) {
      steps.deleteUserStep(accessToken);
    }
  }
}
