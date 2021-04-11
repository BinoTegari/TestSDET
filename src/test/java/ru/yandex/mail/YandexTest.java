package ru.yandex.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LetterCheckWriteSend;
import resourses.Base;

public class YandexTest extends Base{
    Base base = new Base();
    @Before
    public void Login(){
        base.initializeDriver();
        base.user();
    }
    @Test
    public void SortMAil(){
        LetterCheckWriteSend LetterCheckWriteSend = new LetterCheckWriteSend(base.driver);
        LetterCheckWriteSend.getallelements();
        LetterCheckWriteSend.getSubjectFromLetter();
    }
    @After
    public void close() {
        base.driver.quit();
    }
}
//public class YandexTest extends ChromeDriverSettings {
//    private String login = "binotegari@yandex.ru";
//    private String password = "IWantThisJob2021";//Обратите внимание на пароль))
//    private String url = "https://mail.yandex.ru/?noretpath=1";
//
//    @Test
//    public void firstTest() {
//        driver.manage().window().maximize();
//        String url = "https://mail.yandex.ru/?noretpath=1";
//        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]")).sendKeys("BinoTegari@yandex.ru");
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
//
//        WebElement password = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.elementToBeClickable(password));
//        password.sendKeys("IWantThisJob2021");
//
//
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
//        WebElement inbox = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[3]/div/div[1]/div[1]/a[1]/div/span"));
//        WebElement subject = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a/div/span[2]/div/span/span[1]/span[1]/span"));
//
//        WebElement allElementsInPage = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body"));
//        String elementsInPage = allElementsInPage.getText();
//        Pattern pattern = Pattern.compile("Simbirsoft Тестовое задание");
//        Matcher matcher = pattern.matcher(elementsInPage);
//        int count = 0;
//        while(matcher.find()){
//            count++;
//        }
//        String countLetter = "Писем с темой \"Simbirsoft Тестовое задание\" найдено: "+ count;
//        System.out.println(count);
//
//        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[2]/div/div/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")).sendKeys("binotegari@yandex.ru");
//        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")).sendKeys("Simbirsoft Тестовое задание. Перетятько");
//        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/div/div")).sendKeys(countLetter);
//        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")).click();
//    }
//}
