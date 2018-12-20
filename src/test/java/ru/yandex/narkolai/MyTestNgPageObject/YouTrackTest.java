package ru.yandex.narkolai.MyTestNgPageObject;
/*
Co
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.narkolai.MyTestNgPageObject.pages.ReceiptYouTrackPage;
import ru.yandex.narkolai.MyTestNgPageObject.pages.YouTrackPageNewTask;
import ru.yandex.narkolai.MyTestNgPageObject.pages.YouTrackPageLogin;
import ru.yandex.narkolai.MyTestNgPageObject.pages.YouTrackPageTasks;

import static org.testng.Assert.assertTrue;

public class YouTrackTest extends MainTest {

    @Autowired
    public YouTrackPageLogin youTrackPageLogin;

    @Autowired
    public YouTrackPageTasks youTrackPageTasks;

    @Autowired
    public YouTrackPageNewTask youTrackPageNewTask;

    @Autowired
 //   public Utils util;

    @Test
    public void runTest() {
        youTrackPageLogin.logIn("test", "test");

        ReceiptYouTrackPage receiptDtPage = youTrackPageLogin.submit();
        assertTrue(receiptDtPage.isInitialized());

        List<String> expectedHeaderTitles = Arrays.asList("Name", "Code", "used", "Actions");
        youTrackPageNewTask.SelectSecondOrderLink("YouTrack", "Widgets");

        List<String> fetchedHeaderTitles = fetchHeaderTitles(youTrackPageTasks.getTableHeader());

        //Asserts that table column names are the expected ones.
        Assert.assertEquals(expectedHeaderTitles, fetchedHeaderTitles);

        String pageTitle = "Widget";
        //Asserts that the page title is the expected one
        Assert.assertEquals(pageTitle, youTrackPageTasks.getPageTitle().getText());

        //Asserts the presence of the button with displayed name as argument
        assertTrue(checkButtonPresenceByName(driver, "New"));

    }


    //Need move in new class

    List fetchHeaderTitles(WebElement tableHeader) {

        List< WebElement> headerElements = tableHeader.findElements(By.tagName("th"));
        int rows_count = headerElements.size();

        List<String> fetchedHeaderTitles = new ArrayList<String>();

        for (int i = 0; i < rows_count; i++) {
            System.out.println("Header is : " + headerElements.get(i).getText());
            fetchedHeaderTitles.add(headerElements.get(i).getText());
        }

        return fetchedHeaderTitles;

    }
    Boolean checkButtonPresenceByName(WebDriver driver, String buttonName) {
        String buttonLocator = String.format("//button[contains(.,'%s')]", buttonName);

        try {
            return driver.findElement(By.xpath(buttonLocator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
