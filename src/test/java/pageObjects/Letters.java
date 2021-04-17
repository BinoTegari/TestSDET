package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Letters {
    public WebDriver driver;
    String adress      = "mailAdress";
    private String subjectTest = "Simbirsoft Тестовое задание. Перетятько";

//    By allElements   = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]");
    By newLetter     = By.xpath("//a[@class=\"mail-ComposeButton js-main-action-compose\"]");
    By sendAdress    = By.xpath("//div[@class=\"ComposeRecipients-TopRow\"]//div[contains(@class,'MultipleAddressesDesktop-Field')]");
    By subject       = By.xpath("//div[@class=\"ComposeSubject\"]//div[contains(@class,'ComposeSubject-Content')]");
    By letterContent = By.xpath("//div[@class=\"ComposeMbodyCKEditor composeReact__message-body\"]/div[@id=\"cke_editor13\"]");
    By sendButton    = By.xpath("//button/span/div/span[text()=\"Отправить\"]");
    By letterSubject   = By.xpath("//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]/span");
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

    public List<WebElement> letterSubject() { return driver.findElements(letterSubject); }

    public String getSubjectFromLetter() {
        int count = 0;
        String countLetter="Писем с темой \"Simbirsoft Тестовое задание\" найдено: " + count;
        for(int i=0;i<letterSubject().size();i++){
            if(letterSubject().get(i).getText().equals("Simbirsoft Тестовое задание")){
                count++;
            }
        }
        System.out.println(count);
        return  countLetter;
    }
    public void setNewLetter(){
        newLetter().click();
        sendAdress().click();
        sendAdress().sendKeys(adress);
        letterContent().click();
        subject().click();
        subject().sendKeys(subjectTest);
        letterContent().sendKeys(getSubjectFromLetter());
        sendButton().click();
    }
}
