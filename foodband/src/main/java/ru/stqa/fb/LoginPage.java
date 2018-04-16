package ru.stqa.fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

  @FindBy(id = "firstname")
  private WebElement firstName;

  @FindBy(id = "inputLogin")
  private WebElement inputLogin;

  @FindBy(id = "inputPassword")
  private WebElement inputPassword;

  @FindBy(css = "button")
  private WebElement submitButton;


  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public boolean isInitialized() {
    return inputLogin.isDisplayed();
  }

  public void enterLogin(String inputLogin) {
    type(this.inputLogin, inputLogin);

  }

  public void enterPassword(String inputPassword) {
    type(this.inputPassword, inputPassword);

  }

  public MainPage submit() {
    submitButton.click();
    return new MainPage(driver);
  }

}
