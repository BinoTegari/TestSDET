package resourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.UserLogIn;

public class Base {
    public WebDriver driver;

    private String login = "binotegari@yandex.ru";
    private String pass  = "IWantThisJob2021";
    private String url   = "https://mail.yandex.ru/?noretpath=1";

    public void initializeDriver() {
        String currentOS = "";
        if (isWindows()) {
            currentOS = "chromedriver.exe";
        } else if (isMacOs()) {
            currentOS = "chromedriverForMac";
        }
        System.setProperty("webdriver.chrome.driver" , "src/test/Libs/" + currentOS);
        driver = new ChromeDriver();
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }

    public static boolean isMacOs() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }

    public void user() {
        driver.get(url);
        driver.manage().window().maximize();
        UserLogIn UserLogIn = new UserLogIn(driver);
        UserLogIn.signIn().click();
        UserLogIn.getusername().sendKeys(login);
        UserLogIn.nextButton().click();
        UserLogIn.password().sendKeys(pass);
        UserLogIn.submit().click();
    }
}
