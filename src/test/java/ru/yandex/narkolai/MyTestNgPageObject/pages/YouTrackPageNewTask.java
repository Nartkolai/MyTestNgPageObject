package ru.yandex.narkolai.MyTestNgPageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.narkolai.MyTestNgPageObject.PageObject;

public class YouTrackPageNewTask extends PageObject {

    @FindBy(linkText = "1")
    private WebElement page1Tab;
    @FindBy(linkText = "2") //mod
    private WebElement page2Tab;
    @FindBy(linkText = "3") //mod
    private WebElement page3Tab;


    private void selectTab(String tabName) {

        switch (tabName) {

            case "1": {
                page1Tab.click();
                break;
            }
            case "2": {
                page2Tab.click();
                break;
            }
            case "3": {
                page3Tab.click();
                break;

            }
        }
    }
    public void SelectSecondOrderLink(String TabName, String Link) {
        this.selectTab(TabName);
        WebElement secondOrderLink = driver.findElement(By.linkText(Link));
        secondOrderLink.click();

    }

    public YouTrackPageNewTask(WebDriver driver) {
        super(driver);
    }
}
