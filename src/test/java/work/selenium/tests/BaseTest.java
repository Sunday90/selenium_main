package work.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import work.selenium.utils.DriverFactory;
import work.selenium.utils.PropertyReader;

import java.time.Duration;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(PropertyReader.getBaseUrl());
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
