package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLogIn {
  public WebDriver driver;

  @FindBy(how = How.CSS, css = ".button2_theme_mail-white")
  WebElement enterButton;

  @FindBy(how = How.ID, id = "passp-field-login")
  WebElement login;

  @FindBy(how = How.CSS, css = ".Button2_type_submit")
  WebElement submitButton;

  @FindBy(how = How.ID, id = "passp-field-passwd")
  WebElement password;

  public UserLogIn(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver , this);
  }

  public void setLogin(String mailLogin) {
    login.sendKeys(mailLogin);
  }

  public void getEnterButton() {
    enterButton.click();
  }

  public void getSubmitButton() {
    submitButton.click();
  }

  public void setPassword(String mailPassword) {
    WebDriverWait wait = new WebDriverWait(driver , 20);
    wait.until(ExpectedConditions.elementToBeClickable(password));
    password.sendKeys(mailPassword);
    password.click();
  }
}
