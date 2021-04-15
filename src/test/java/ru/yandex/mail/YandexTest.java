package ru.yandex.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.LetterCheckWriteSend;
import resourses.Base;

public class YandexTest extends Base {
    Base base = new Base();

    @Before
    public void Login() {
        base.initializeDriver();
        base.user();
    }

    @Test
    public void SortMail() {
        LetterCheckWriteSend LetterCheckWriteSend = new LetterCheckWriteSend(base.driver);
        LetterCheckWriteSend.getallelements();
        LetterCheckWriteSend.getSubjectFromLetter();
    }
    @After
    public void close() {
        base.driver.quit();
    }
}
