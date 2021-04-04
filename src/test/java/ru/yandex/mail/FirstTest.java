package ru.yandex.mail;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class FirstTest extends ChromeDriverSettings {

    @Test
    public void firstTest()  {
        driver.get("https://mail.yandex.ru/?noretpath=1");


        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys("binotegari@yandex.ru");
        driver.findElement(By.className("passp-sign-in-button")).click();
        driver.findElement(By.linkText("ВВедите пароль")).sendKeys("CrimsonKing21");
//        driver.findElementByXPath("//*[@id=\"passp-field-passwd\"]").sendKeys("CrimsonKing21");
//        driver.findElement(By.id("passp-field-passwd")).sendKeys("CrimsonKing21");
//        driver.findElement(By.className("passp-sign-in-button")).click();
//        String title = driver.getTitle();
////        String button = driver.findElementByLinkText("Войти").getText();
////        System.out.println(button);
//        Assert.assertEquals("Яндекс.Почта — бесплатная и надежная электронная почта", title);
    }
}
