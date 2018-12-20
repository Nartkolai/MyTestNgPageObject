package ru.yandex.narkolai.MyTestNgPageObject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YandexPageTest extends MainTest{

    @Test
    public void openPage() {
        driver.get("https://yandex.ru");
        String titleActual = driver.getTitle();
        String titleExpected = "Яндекс!";
        Assert.assertEquals(titleActual, titleExpected);

    }
}
