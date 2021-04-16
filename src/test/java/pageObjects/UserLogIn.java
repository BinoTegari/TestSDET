package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLogIn {
    public WebDriver driver;

    By enterButton     = By.xpath("//div[@class=\"HeadBanner-ButtonsWrapper\"]/a[span[text()=\"Войти\"]]");
    By username   = By.xpath("//*[@id=\"passp-field-login\"]");
    By enterAfterLoginButton = By.xpath("//div[@class=\"passp-button passp-sign-in-button\"]/button");
    By password   = By.xpath("//*[@id=\"passp-field-passwd\"]");
    By submit     = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/form/div[3]/button");

    public UserLogIn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement enterButton() {
        return driver.findElement(enterButton);
    }

    public WebElement getusername() {
        return driver.findElement(username);
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

    public WebElement submit() {
        return driver.findElement(submit);
    }
}
