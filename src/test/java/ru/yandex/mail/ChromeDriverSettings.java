package ru.yandex.mail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src/test/Libs/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public  void close(){
        driver.quit();
    }
}
