package work.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import work.selenium.utils.DriverFactory;
import work.selenium.utils.PropertyReader;

import java.time.Duration;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(PropertyReader.getBaseUrl());
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
