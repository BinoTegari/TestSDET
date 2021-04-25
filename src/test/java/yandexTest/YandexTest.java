package yandexTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.Letters;
import resourсes.Base;

public class YandexTest extends Base {
  String subjectTheme = "Simbirsoft Тестовое задание. Перетятько";
  String searchSubject = "Simbirsoft Тестовое задание";
  Base base = new Base();

  @Before
  public void login() {
    base.initializeDriver();
    base.open();
    base.userLogIn();
  }

  @Test
  public void getMailSubject() {
    Letters letters = new Letters(base.driver);
    letters.sendNewLetter(base.property.getProperty("mailAdress") , subjectTheme , searchSubject);
  }

  @After
  public void close() {
    base.driver.quit();
  }
}
