package work.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import work.selenium.tests.BaseTest;

import javax.swing.*;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions builder;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        this.builder = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
