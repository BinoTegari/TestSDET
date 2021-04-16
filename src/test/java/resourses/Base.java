package resourses;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.UserLogIn;

public class Base {
    public WebDriver driver;
    public Properties properties = new Properties();

    public String login =properties.getProperty("mailLogin");
    public String password  = properties.getProperty("mailPassword");
    public String url   = "https://mail.yandex.ru/?noretpath=1";

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
        UserLogIn.enterButton().click();
        UserLogIn.getusername().sendKeys(login);
        UserLogIn.enterAfterLoginButton().click();
        UserLogIn.password().sendKeys(password);
        UserLogIn.submit().click();
    }
}
