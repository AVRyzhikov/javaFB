package ru.stqa.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

import java.util.List;

public class ProductsPage extends PageObject {

  @FindBy(linkText = "WOK")
  private WebElement wok;

  @FindBy(linkText = "Напитки")
  private WebElement drink;

  @FindBy(linkText = "Безалкогольные")
  private WebElement nonAlcocol;

  @FindBy(linkText = "Продукция")
  private WebElement products;

  @FindBy(linkText = "Заказ")
  private WebElement order;

  @FindBy(xpath = "//textarea[@id='']")
  private WebElement commentInput;

  @FindBy(xpath = "//button[.='Сохранить']")
  private WebElement commentSave;


  public ProductsPage(WebDriver driver) {
    super(driver);
  }

  public void wokChoice() {

    wok.click();
  }

  public void drinkChoice() {
    drink.click();
  }

  public void nonAlcocolChoice() {
    nonAlcocol.click();
  }

  public OrderPage submitOrder() {
    order.click();
    return new OrderPage(driver);
  }

  public void productSelect(String s1, String s2) {

    switch (s2) {
      case "Обычный":
        element = driver.findElement(By.xpath("//span[.='" + s1 + "']/../..//button[1]"));
        element.click();
        break;
      case "Острый":
        element = driver.findElement(By.xpath("//span[.='" + s1 + "']/../..//button[2]"));
        element.click();
        break;
      default:
        System.out.println("Неверен тип продукта!");
        break;
    }
  }

  public void drinkSelect(String s) {
    element = driver.findElement(By.xpath("//span[.='" + s + "']/../..//button"));
    element.click();

  }

  public void clickTableButton(int i, int j) {

    element = driver.findElement(By.xpath("((//div[@class='tr row'])[" + i + "]//button)[" + j + "]"));

    element.click();

  }

  public void typeComment(String comment) {
    type(this.commentInput, comment);

  }

  public void inComment(int i, String comment) {
    if (comment != "Добавить комментарий") {
      int j = 3;
      if (i == 1)
        j = j + 1;
      clickTableButton(i, j);
      typeComment(comment);
      this.commentSave.click();
    }
  }

  public void qtDrink(int qt) {

    for (int j = 2; j < qt + 1; j++)
      clickTableButton(2, 2);

  }

  public boolean isInitialized() {
    return products.isDisplayed() & order.isDisplayed();
  }

  public void testProduct(Order orderG, int i) {
    List<WebElement> clDiv = driver.findElements(By.xpath("(//div[@class='tr row'])[" + i + "]//div"));
    List<WebElement> clSpan = driver.findElements(By.xpath("(//div[@class='tr row'])[" + i + "]//span"));
    String sign = driver.findElement(By.xpath("((//div[@class='tr row'])[" + i + "]//button)[1]//i")).getAttribute("class");

    switch (i) {
      case 1:
        assertEquals(clDiv.get(0).getText(), Integer.toString(i)); // порядковый номер
        assertEquals(clDiv.get(1).getText(), orderG.nameWOK + " " + orderG.typeWOK); //  название продукта WOK и тип
        assertEquals("fa fa-plus", sign);  // наличие кнопки +
        assertEquals(clDiv.get(2).getText(), Integer.toString(orderG.qtWOK));  // количество продуктов WOK
        assertEquals(clSpan.get(2).getText(), orderG.commentWOK);  // комментарий пролукта WOK
        assertEquals(clDiv.get(3).getText(), Integer.toString(orderG.priceWOK) + " р.");  // цена продукта WOK
        assertEquals(clDiv.get(4).getText(), "% 0 р.");  // скидка
        assertEquals(clDiv.get(6).getText(), Integer.toString(orderG.costWOK()) + " р.");  // стоимость продукта WOK
        break;

      case 2:
        assertEquals(clDiv.get(0).getText(), Integer.toString(i)); // порядковый номер
        assertEquals(clDiv.get(1).getText(), orderG.nameDrink); //  название напитка WOK и тип
        assertEquals("fa fa-minus", sign);  // отсутствие кнопки +
        assertEquals(clDiv.get(2).getText(), Integer.toString(orderG.qtDrink));  // количество напитков
        assertEquals(clSpan.get(2).getText(), orderG.commentDrink);  // комментарий напитка
        assertEquals(clDiv.get(3).getText(), Integer.toString(orderG.priceDrink) + " р.");  // цена напитка
        assertEquals(clDiv.get(4).getText(), "% 0 р.");  // скидка
        assertEquals(clDiv.get(6).getText(), Integer.toString(orderG.costDrink()) + " р.");  // стоимость напитка
        break;
      default:
        System.out.println("Порядковый номер " + i + "напитка(продукта) неверен !");
        break;
    }
  }
}
