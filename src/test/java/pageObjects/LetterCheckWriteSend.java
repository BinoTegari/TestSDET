package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Properties;

public class LetterCheckWriteSend {
    public WebDriver driver;
    public Properties properties;
    String adress      = "mailAdress";
    private String subjectTest = "Simbirsoft Тестовое задание. Перетятько";

    By allElements   = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]");
    By newLetter     = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[2]/div/div/a");
    By sendAdress    = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div");
    By subject       = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input");
    By letterContent = By.xpath("//*[@id=\"cke_1_contents\"]/div/div");
    By sendButton    = By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button");
    By testSubject   = By.xpath("//span[@class=\"mail-MessageSnippet-Item mail-MessageSnippet-Item_subject\"]/span");
    public LetterCheckWriteSend(WebDriver driver,Properties properties) {
        this.driver = driver;
        this.properties = properties;
    }

    public WebElement getallelements() {
        WebDriverWait webDriverWait = new WebDriverWait(driver , 20);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(allElements));
        return driver.findElement(allElements);
    }

    public WebElement newLetter() {
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

    public List<WebElement> testSubject() { return driver.findElements(testSubject); }

    public void getSubjectFromLetter() {
        int count = 0;
        int uncount =0;
        for(int i=0;i<testSubject().size();i++){
            if(testSubject().get(i).getText().equals("Simbirsoft Тестовое задание")){
                count++;
            }else if(testSubject().get(i).getText().equals("Simbirsoft Тестовое задание. Перетятько")){
                uncount++;
            }
        }
        System.out.println(count);
        System.out.println(uncount);


//        getallelements();
//        String elementsInPage = getallelements().getText();
////За это решение могу сказать только - в пианиста не стреляйте, играет как умеет))Знаю что костыль, но
////совсем времени не было исправлять
//        Pattern pattern = Pattern.compile("Simbirsoft Тестовое задание");
//        Pattern patternPeretyatko = Pattern.compile("Simbirsoft Тестовое задание\\. Перетятько");
//        Matcher matcher = pattern.matcher(elementsInPage);
//        Matcher matcherPeretyatko = patternPeretyatko.matcher(elementsInPage);
//        int count = 0;
//        int countPeretyatko = 0;
//        while (matcher.find()) {
//            count++;
//        }
//        while (matcherPeretyatko.find()) {
//            countPeretyatko++;
//        }
//
//        String countLetter = "Писем с темой \"Simbirsoft Тестовое задание\" найдено: " + (count - countPeretyatko * 2);
//        System.out.println((count - countPeretyatko * 2) + " после цикла");
//        newLetter().click();
//        sendAdress().click();
//        sendAdress().sendKeys(adress);
//        letterContent().click();
//        subject().click();
//        subject().sendKeys(subjectTest);
//        letterContent().sendKeys(countLetter);
//        sendButton().click();
    }
}
