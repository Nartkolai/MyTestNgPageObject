package ru.yandex.narkolai.MyTestNgPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.narkolai.MyTestNgPageObject.PageObject;

public class ReceiptYouTrackPage extends PageObject {
    @FindBy(xpath = "//div[contains(@class, 'ng-binding ng-scope header__text__error')]")
    private WebElement header;

    public ReceiptYouTrackPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return header.isDisplayed();
    }

    public String confirmationHeader() {
        return header.getText();
    }
}
