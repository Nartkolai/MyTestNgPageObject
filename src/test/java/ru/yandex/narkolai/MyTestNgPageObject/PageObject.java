package ru.yandex.narkolai.MyTestNgPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject extends MainTest{

    public PageObject(WebDriver driver) {
        MainTest.driver = driver;
        PageFactory.initElements(driver, this);
    }
}