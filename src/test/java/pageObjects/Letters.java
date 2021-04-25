package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Letters {
  public WebDriver driver;

  @FindBy(how = How.CSS, css = ".mail-ComposeButton")
  WebElement newLetter;

  @FindBy(how = How.XPATH, xpath = "//div[@class=\"ComposeRecipients-TopRow\"]//div/div[@class=\"composeYabbles\"]")
  WebElement sendAdress;

  @FindBy(how = How.CSS, css = ".ComposeSubject-TextField")
  WebElement subject;

  @FindBy(how = How.CSS, css = ".cke_editable:not(#cke_pastebin)")
  WebElement letterContent;

  @FindBy(how = How.CSS, css = ".theme-colorful .ComposeSendButton .button2.button2.button2")
  WebElement sendButton;

  @FindBy(how = How.CSS, css = ".mail-MessageSnippet.is-unread .mail-MessageSnippet-Item_subject")
  List<WebElement> letterSubject;

  public Letters(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver , this);
  }

  private void newLetter() {
    WebDriverWait wait = new WebDriverWait(driver , 20);
    wait.until(ExpectedConditions.elementToBeClickable(newLetter));
    newLetter.click();
  }

  private void setSendAdress(String mailAdress) {
    WebDriverWait webDriverWait = new WebDriverWait(driver , 20);
    webDriverWait.until(ExpectedConditions.elementToBeClickable(sendAdress));
    sendAdress.sendKeys(mailAdress);
  }

  private void setSubject(String subjectTheme) {
    subject.click();
    subject.sendKeys(subjectTheme);
  }

  private void letterContent(String searchSubject) {
    letterContent.click();
    letterContent.sendKeys(getSubjectFromLetter(searchSubject));
  }

  private void getSendButton() {
    sendButton.click();
  }

  public String getSubjectFromLetter(String searchSubject) {
    int count = 0;

    for (WebElement webElement : letterSubject) {
      if (webElement.getText().equals(searchSubject)) {
        count++;
      }
    }
    return "Писем с темой \"Simbirsoft Тестовое задание\" найдено: " + count;
  }

  public void sendNewLetter(String mailAdress , String subjectTheme , String searchSubject) {
    newLetter();
    setSendAdress(mailAdress);
    setSubject(subjectTheme);
    letterContent(searchSubject);
    getSendButton();
  }
}
