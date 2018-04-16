package ru.stqa.fb;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class TestBase {

  protected static WebDriver driver;
  protected static Order orderG;


  public void signUp() {

    LoginPage loginPage = new LoginPage(driver);

    loginPage.enterLogin("operator");
    loginPage.enterPassword("operator");

    MainPage mainPage = loginPage.submit();
    assertTrue(mainPage.isInitialized());

    OrderListPage orderListPage = mainPage.submit();
    assertTrue(orderListPage.isInitialized());
  }

  @BeforeClass
  public static void setUp() {

    orderG = new Order("Удон с говядиной Ньюпай", "Острый", 385, 1, "Добавить комментарий",
            "Морс ягодный", 220, 2, "Добавить комментарий",
            "0001239745", "Тестов Тест", "Пятницкая улица, 20", "Наличные",
            "Новокузнецкий", "Телефон", 900);

    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    driver.get("http://88.99.27.54:6012");


  }

  @After
  public void cleanUp() {
    driver.manage().deleteAllCookies();
  }

  @AfterClass
  public static void tearDown() {
    driver.close();
  }
}

