package ru.yandex.mail;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver","src/test/Libs/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://mail.yandex.ru/?noretpath=1");
    }
}
