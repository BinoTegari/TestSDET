package ru.yandex.mail;

import org.junit.Assert;
import org.junit.Test;

public class FirstTest extends ChromeDriverSettings {

    @Test
    public void firstTest() {

        driver.get("https://mail.yandex.ru/?noretpath=1");
        String title = driver.getTitle();
        Assert.assertEquals("Яндекс.Почта — бесплатная и надежная электронная почта", title);
    }

}
