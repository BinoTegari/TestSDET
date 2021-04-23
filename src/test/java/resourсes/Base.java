package resourсes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageObjects.UserLogIn;
import services.ConfigureService;

public class Base {
  public WebDriver driver;
  public Properties property;

  private String login;
  private String password;
  private String url;
  private static String adress;

  public void initializeDriver() {
    try {
      String currentOS = "";
      if (isWindows()) {
        currentOS = "chromedriver.exe";
      } else if (isMacOs()) {
        currentOS = "chromedriverForMac";
      }
      System.setProperty("webdriver.chrome.driver" , "src/test/Libs/" + currentOS);
      ChromeOptions capabilities = new ChromeOptions();
      capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR , UnexpectedAlertBehaviour.IGNORE);
      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabilities);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public static boolean isWindows() {
    String os = System.getProperty("os.name").toLowerCase();
    return (os.contains("win"));
  }

  public static boolean isMacOs() {
    String os = System.getProperty("os.name").toLowerCase();
    return (os.contains("mac"));
  }

  public void userLogIn() {
    if (this.property == null) {
      System.out.println("config не читается");
      return;
    }
    UserLogIn UserLogIn = new UserLogIn(driver);
    UserLogIn.enterButton().click();
    UserLogIn.login().sendKeys(login);
    UserLogIn.enterAfterLoginButton().click();
    UserLogIn.password().sendKeys(password);
    UserLogIn.enterAfterPasswordButton().click();
  }
  public void open() {
    driver.get(url);
    driver.manage().window().maximize();
  }
  public Base() {
    this.property = ConfigureService.getInstance().getProperties();
    this.readProperties();
  }

  public void readProperties() {
    this.url = property.getProperty("mailUrl");
    this.login = property.getProperty("mailLogin");
    this.password = property.getProperty("mailPassword");
    adress = property.getProperty("mailAdress");
  }

  public static String getAdress() {
    return adress;
  }
}
