package ru.yandex.mail;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setup() {
        String currentOS = "";
        if (isWindows()) {
            currentOS = "chromedriver.exe";
        } else if (isMacOs()) {
            currentOS = "chromedriverForMac";
        }
        System.setProperty("webdriver.chrome.driver", "src/test/Libs/" + currentOS);
        driver = new ChromeDriver();
    }

//    @After
//    public void close() {
//        driver.quit();
//    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }

    public static boolean isMacOs() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }
}
