package ru.yandex.mail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YandexTest extends ChromeDriverSettings {
    private String login = "";
    private String password = "";//Обратите внимание на пароль))
    private String url = "https://mail.yandex.ru/?noretpath=1";
    YandexSignIn yandexSignIn = new YandexSignIn();
    @Test
    public void firstTest() {
        yandexSignIn.signIn(login,password,url);
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


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();
        WebElement inbox = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[3]/div/div[1]/div[1]/a[1]/div/span"));
        WebElement subject = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/div/div[1]/div/div/div/a/div/span[2]/div/span/span[1]/span[1]/span"));

        WebElement allElementsInPage = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body"));
        String elementsInPage = allElementsInPage.getText();
        Pattern pattern = Pattern.compile("Simbirsoft Тестовое задание");
        Matcher matcher = pattern.matcher(elementsInPage);
        int count = 0;
        while(matcher.find()){
            count++;
        }
        String countLetter = "Писем с темой \"Simbirsoft Тестовое задание\" найдено: "+ count;
        System.out.println(count);

        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")).sendKeys("binotegari@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")).sendKeys("Simbirsoft Тестовое задание. Перетятько");
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/div/div")).sendKeys(countLetter);
        driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")).click();
    }
}
