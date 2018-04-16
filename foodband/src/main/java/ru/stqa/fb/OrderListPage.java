package ru.stqa.fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderListPage extends PageObject {


  public OrderListPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(css = "i")
  private WebElement choiceMenu;

  @FindBy(linkText = "Новый заказ")
  private WebElement newOrder;


  public ProductsPage submitProductsPage() {
    choiceMenu.click();
    newOrder.click();
    return new ProductsPage(driver);
  }

  public boolean isInitialized() {
    return newOrder.isDisplayed();
  }
}
