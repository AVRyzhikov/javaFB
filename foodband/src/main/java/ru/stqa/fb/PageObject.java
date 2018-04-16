package ru.stqa.fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObject {
  protected WebDriver driver;
  public WebElement element;
  public Select select;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void type(WebElement element, String value) {
    element.click();
    element.clear();
    element.sendKeys(value);
  }

  public void type2(WebElement element, String value) {
    element.click();
    element.sendKeys(value);
  }

  public Select getSelect(WebElement element) {
    select = new Select(element);
    return select;
  }
}
