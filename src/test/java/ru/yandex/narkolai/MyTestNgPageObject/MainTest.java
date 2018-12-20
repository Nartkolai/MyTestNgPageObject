package ru.yandex.narkolai.MyTestNgPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class MainTest {
    protected static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    protected WebDriver getDriver(@Optional("chrome") String browser) {
        if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "d:\\Users\\MyProject\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/d/Users/MyProject/drivers/geckodriver32.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    @AfterTest
    protected void tearDown() {
        if(driver != null)
            driver.quit();
    }
}
