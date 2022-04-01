package work.selenium.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class DriverFactory {
    private static WebDriver driver;
    private static final String LOCAL_DRIVER_PATH = "src/test/resources/";
    private static File file;

    public static WebDriver getRemoteDriver(String platform, String browser, String version) {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("platformName", platform);
        options.setCapability("browserName", browser);
        options.setCapability("browserVersion", version);
        options.setBinary("C:\\selenium-grid\\");

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.9:4444/wd/hub"), options);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }


    public static WebDriver getLocalDriver(String browser) {
        Browser b = Browser.valueOf(browser.toUpperCase(Locale.ROOT));
        switch (b) {
            case CHROME:
                file = new File(LOCAL_DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;

            case FIREFOX:
                file = new File(LOCAL_DRIVER_PATH + "geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }
}
