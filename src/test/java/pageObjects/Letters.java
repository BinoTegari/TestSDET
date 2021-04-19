package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resourсes.Base;
import java.util.List;

public class Letters {
  public WebDriver driver;
  String subjectTheme = "Simbirsoft Тестовое задание. Перетятько";

  By newLetter = By.xpath("//a[@class=\"mail-ComposeButton js-main-action-compose\"]");
  By sendAdress = By.xpath("//div[@class=\"ComposeRecipients-TopRow\"]//div/div[@class=\"composeYabbles\"]");
  By subject = By.xpath("//div[@class=\"ComposeSubject\"]//div[contains(@class,'ComposeSubject-Content')]/input");
  By letterContent = By.xpath("//div[@id=\"cke_1_contents\"]/div[@placeholder=\"Напишите что-нибудь\"]");
  By sendButton = By.xpath("//div[contains(@class,'ComposeSendButton_desktop')]/button");
  By letterSubject = By.xpath("//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]/span");

  public Letters(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement newLetter() {
    WebDriverWait wait = new WebDriverWait(driver , 20);
    wait.until(ExpectedConditions.elementToBeClickable(newLetter));
    return driver.findElement(newLetter);
  }

  public WebElement sendAdress() {
    WebDriverWait webDriverWait = new WebDriverWait(driver , 20);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(sendAdress));
    return driver.findElement(sendAdress);
  }

  public WebElement subject() {
    return driver.findElement(subject);
  }

  public WebElement letterContent() {
    return driver.findElement(letterContent);
  }

  public WebElement sendButton() {
    return driver.findElement(sendButton);
  }

  public List<WebElement> letterSubject() {
    return driver.findElements(letterSubject);
  }

  public String getSubjectFromLetter() {
    int count = 0;

    for (int i = 0; i < letterSubject().size(); i++) {
      if (letterSubject().get(i).getText().equals("Simbirsoft Тестовое задание")) {
        count++;
      }
    }
    String countLetter = "Писем с темой \"Simbirsoft Тестовое задание\" найдено: " + count;
    return countLetter;
  }

  public void sendNewLetter() {
    newLetter().click();
    sendAdress().click();
    sendAdress().sendKeys(Base.getAdress());
    subject().click();
    subject().sendKeys(subjectTheme);
    letterContent().click();
    letterContent().sendKeys(getSubjectFromLetter());
    sendButton().click();
  }
}
