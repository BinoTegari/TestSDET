package ru.yandex.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YandexSignIn extends ChromeDriverSettings{
    public void signIn(String login,String password, String url){
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"passp-field-login\"]")).sendKeys(login);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div[1]/form/div[3]/button")).click();

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"passp-field-passwd\"]"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
    }
}
