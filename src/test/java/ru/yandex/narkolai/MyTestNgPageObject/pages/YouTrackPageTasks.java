package ru.yandex.narkolai.MyTestNgPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.narkolai.MyTestNgPageObject.PageObject;

public class YouTrackPageTasks extends PageObject {

    @FindBy(css = "title > YouTrack")
    private WebElement pageTitle;

    @FindBy(css = "table > thead")
    private WebElement tableHeader;

    @FindBy(css = "table > tbody")
    private WebElement tableBody;

    @FindBy(xpath = "//button[contains(.,'New')]")
    private WebElement newButton;

    public WebElement getPageTitle() {
        return this.pageTitle;
    }

    public WebElement getTableHeader() {
        return this.tableHeader;
    }

    public WebElement getTableBody() {
        return this.tableBody;

    }

    public WebElement getNewDataTypeButton() {
        return this.newButton;

    }

    public YouTrackPageTasks(WebDriver driver) {
        super(driver);
    }
}
