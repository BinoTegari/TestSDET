package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLogIn {
    public WebDriver driver;

    By enterButton     = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[span[text()=\"Войти\"]]");
    By login   = By.xpath("//*[@id=\"passp-field-login\"]");
    By enterAfterLoginButton = By.xpath("//div[@class=\"passp-button passp-sign-in-button\"]/button");
    By password   = By.xpath("//*[@id=\"passp-field-passwd\"]");
    By enterAfterPasswordButton     = By.xpath("//div[@class=\"passp-button passp-sign-in-button\"]/button");

    public UserLogIn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement enterButton() {
        return driver.findElement(enterButton);
    }

    public WebElement login() {
        return driver.findElement(login);
    }

    public WebElement enterAfterLoginButton() {
        return driver.findElement(enterAfterLoginButton);
    }

    public WebElement password() {
        WebDriverWait wait = new WebDriverWait(driver , 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        driver.findElement(password).click();
        return driver.findElement(password);
    }

    public WebElement enterAfterPasswordButton() {
        return driver.findElement(enterAfterPasswordButton);
    }
}
