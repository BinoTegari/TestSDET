package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterCheckWriteSend {
        public WebDriver driver;

        private String adress = "binotegari@yandex.ru";
        private String subjectTest = "Simbirsoft Тестовое задание. Перетятько";

        By allElements = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]");
        By newLetter = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[2]/div/div/a");
        By sendAdress = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div");
        By subject = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input");
        By letterContent = By.xpath("//*[@id=\"cke_1_contents\"]/div/div");
        By sendButton = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button");
        public LetterCheckWriteSend(WebDriver driver) {
            this.driver = driver;
        }
        public WebElement getallelements(){
            WebDriverWait webDriverWait = new WebDriverWait(driver,20);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(allElements));
            return driver.findElement(allElements);
        }
        public WebElement newLetter(){
            return driver.findElement(newLetter);
        }

        public WebElement sendAdress(){
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.elementToBeClickable(sendAdress));
            return driver.findElement(sendAdress);
        }

        public WebElement subject(){
            return driver.findElement(subject);
        }

        public WebElement letterContent(){
            return driver.findElement(letterContent);
        }

        public WebElement sendButton(){
            return driver.findElement(sendButton);
        }
    public void getSubjectFromLetter(){
        getallelements();
        String elementsInPage = getallelements().getText();
        Pattern pattern = Pattern.compile("^Simbirsoft Тестовое задание$");
        Matcher matcher = pattern.matcher(elementsInPage);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        String countLetter = "Писем с темой \"Simbirsoft Тестовое задание\" найдено: "+ count;
        System.out.println(count);
        newLetter().click();
        sendAdress().sendKeys(adress);
        subject().sendKeys(subjectTest);
        letterContent().sendKeys(countLetter);
        sendButton().click();
    }
}
