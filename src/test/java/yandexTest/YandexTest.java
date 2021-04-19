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
        Letters letters = new Letters(base.driver);
        letters.getSubjectFromLetter();
        letters.sendNewLetter();
    }

    @After
    public void close() throws InterruptedException {
        //Это только для визуальной оценки финала теста
        Thread.sleep(2000);
        base.driver.quit();
    }
}
