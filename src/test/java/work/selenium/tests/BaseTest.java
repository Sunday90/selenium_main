package work.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import work.selenium.utils.DriverFactory;
import work.selenium.utils.PropertyReader;
import work.selenium.utils.ScreenshotUtil;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

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


    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM.dd HH-mm-ss");
            String fileName = String.format("%s_%s", testResult.getName(), formatter.format(new Date()));

            ScreenshotUtil.getScreenSizePageScreenshot(driver, fileName);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
