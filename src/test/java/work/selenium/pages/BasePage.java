package work.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import work.selenium.tests.BaseTest;
import work.selenium.utils.Constants;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait waitElementToBeVisible;
    protected Actions builder;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        this.waitElementToBeVisible = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
        this.builder = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    //Ожидание видимости элемента
    public boolean isElementVisible(WebElement element) {
        try {
            waitElementToBeVisible.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
