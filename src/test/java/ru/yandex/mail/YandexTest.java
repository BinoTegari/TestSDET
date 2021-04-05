package ru.yandex.mail;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class YandexTest extends ChromeDriverSettings {

    @Test
    public void firstTest()  {

        driver.manage().window().maximize();
        String url = "https://mail.yandex.ru/?noretpath=1";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")).click();
        WebElement email_phone = driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]"));
        email_phone.sendKeys("BinoTegari@yandex.ru");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();
        WebElement password = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("IWantThisJob2021");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button")).click();

        WebElement inbox = driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[7]/div/div[3]/div[2]/div[3]/div/div[1]/div[1]/a[1]/div/span"));
        System.out.println(inbox.getText());
        
    }
}
