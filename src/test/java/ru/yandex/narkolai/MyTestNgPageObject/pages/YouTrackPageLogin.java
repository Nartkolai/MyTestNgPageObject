package ru.yandex.narkolai.MyTestNgPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.narkolai.MyTestNgPageObject.PageObject;
import ru.yandex.narkolai.MyTestNgPageObject.pages.ReceiptYouTrackPage;

public class YouTrackPageLogin extends PageObject {

    @FindBy(id = "username")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@data-test='login-button']")
    private WebElement loginButton;

    public void logIn(String userName, String passWr) {
        this.loginField.clear();
        this.loginField.sendKeys(userName);

        this.passwordField.clear();
        this.passwordField.sendKeys(passWr);
    }


    public YouTrackPageLogin(WebDriver driver) {
        super(driver);
        driver.get("http://localhost:38083");
    }

    public ReceiptYouTrackPage submit() {
        loginButton.click();
        return new ReceiptYouTrackPage(driver);
    }




    public void clickLoginButton() {
        loginButton.click();
    }


}
