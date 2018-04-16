package ru.stqa.fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {

  @FindBy(css = "i")
  private WebElement choiceMenu;

  @FindBy(linkText = "Оператор")
  private WebElement operator;

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public OrderListPage submit() {
    choiceMenu.click();
    operator.click();

    return new OrderListPage(driver);
  }

  public boolean isInitialized() {
    return choiceMenu.isDisplayed();
  }
}
