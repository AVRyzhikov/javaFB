package ru.stqa.fb;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;


public class OrderPage extends PageObject {

  public OrderPage(WebDriver driver) {
    super(driver);

  }


  @FindBy(linkText = "Продукция")
  private WebElement products;

  @FindBy(linkText = "Заказ")
  private WebElement order;

  @FindBy(id = "phone")
  private WebElement phone;

  @FindBy(xpath = "//input[@id='deal']")
  private WebElement deal;

  @FindBy(id = "name")
  private WebElement name;

  @FindBy(id = "paymentTypeNew")
  private WebElement paymentTypeNew;

  @FindBy(xpath = "//input[@placeholder='Улица, дом']")
  private WebElement address;

  @FindBy(xpath = "//h4[@class='list-group-item-heading address-text ng-binding']")
  private WebElement addressOld;

  @FindBy(xpath = "//button[.='Готовить!']")
  public WebElement ready;

  @FindBy(css = "#affiliate")

  private WebElement filial;

  @FindBy(xpath = "//select[@id='source']")
  private WebElement source;


  @FindBy(xpath = "//h4[@class='col-md-12 text-warning amount ng-binding']")
  private WebElement toPay;

  public ProductsPage submitProductsPage() {
    products.click();
    return new ProductsPage(driver);
  }


  public void fill(String phoneClient, String nameClient, String addressClient, String paymentTypeClient) {
    type(phone, phoneClient);
    type(name, nameClient);
    if (addressOld.isDisplayed())
      addressOld.click();
    type(address, addressClient);
    address.click();
    address.sendKeys(Keys.ENTER);

    driver.findElement(By.xpath("(//option[@value='1'])[3]")).click();

  }

  public void testProduct(Order orderG) {

    getSelect(filial);

    filial.click();
    WebElement selectedOption = select.getFirstSelectedOption();
    while (selectedOption.getText().equals(""))
      selectedOption = select.getFirstSelectedOption();
    assertEquals(selectedOption.getText(), orderG.filial); // филиал

    getSelect(source);
    selectedOption = select.getFirstSelectedOption();
    assertEquals(selectedOption.getText(), orderG.source); // источник

    assertEquals(deal.getAttribute("value"), Integer.toString(orderG.deal)); // сдача c

    assertEquals(toPay.getText(), Integer.toString(orderG.costWOK() + orderG.costDrink()) + ",00 р."); // коплате


  }
}
