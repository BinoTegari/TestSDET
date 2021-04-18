package yandexTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.Letters;
import resourсes.Base;

public class YandexTest extends Base {
    Base base = new Base();

    @Before
    public void Login() {
        base.initializeDriver();
        base.user();
    }

    @Test
    public void GetMailSubject() {
        Letters Letters = new Letters(base.driver);
        Letters.getSubjectFromLetter();
        Letters.sendNewLetter();
    }

//    @After
//    public void close() {
//        base.driver.quit();
//    }
}
