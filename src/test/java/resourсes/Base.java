package resourсes;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.UserLogIn;
import services.ConfigureService;

public class Base {
  public WebDriver  driver;
  public Properties property;

  private String login;
  private String password;
  private String url;

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
    if (this.property == null) {
      System.out.println("config не читается");
      return;
    }
    driver.get(url);
    driver.manage().window().maximize();
    UserLogIn UserLogIn = new UserLogIn(driver);
    UserLogIn.enterButton().click();
    UserLogIn.login().sendKeys(login);
    UserLogIn.enterAfterLoginButton().click();
    UserLogIn.password().sendKeys(password);
    UserLogIn.enterAfterPasswordButton().click();
  }

  public Base() {
    this.property = ConfigureService.getInstance().getProperties();
    this.readProperties();
  }

  public void readProperties() {
    this.url = property.getProperty("mailUrl");
    this.login = property.getProperty("mailLogin");
    this.password = property.getProperty("mailPassword");

  }

  public Properties getProperty() {
    return property;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getUrl() {
    return url;
  }
}
