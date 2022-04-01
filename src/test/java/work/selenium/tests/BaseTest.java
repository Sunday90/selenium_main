package work.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import work.selenium.utils.Constants;
import work.selenium.utils.DriverFactory;
import work.selenium.utils.ScreenshotUtil;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BaseTest {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    @Parameters({"platform", "browser", "version", "url", "local"})
    @BeforeSuite
    public static void setUp(String platform, String browser, String version, String url, String local) {
        if (Boolean.valueOf(local) == true) {
            driver = DriverFactory.getLocalDriver(browser);
        } else {
            driver = DriverFactory.getRemoteDriver(platform, browser, version);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        driver.manage().window().maximize();
        driver.get(url);
    }


    //Скриншот если тест провален
    @AfterMethod
    public static void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM.dd HH-mm-ss");
            String fileName = String.format("%s_%s", testResult.getName(), formatter.format(new Date()));

            ScreenshotUtil.getScreenSizePageScreenshot(driver, fileName);
        }
    }

    @AfterSuite
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
