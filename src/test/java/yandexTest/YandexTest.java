package yandexTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.Letters;
import resourсes.Base;

public class YandexTest extends Base {
    Base base = new Base();

    @Before
    public void login() {
        base.initializeDriver();
        base.user();
    }

    @Test
    public void getMailSubject() {
        Letters letters = new Letters(base.driver);
        letters.getSubjectFromLetter();
        letters.sendNewLetter();
    }

    @After
    public void close() {
        base.driver.quit();
    }
}
