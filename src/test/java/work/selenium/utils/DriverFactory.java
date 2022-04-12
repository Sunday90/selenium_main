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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;
    private static final String LOCAL_DRIVER_PATH = "src/test/resources/";
    private static File file;


    //Подготовка Selenoid веб-драйвера
    public static WebDriver getRemoteDriver(String platform, String browser, String version) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(browser);
        desiredCapabilities.setVersion(version);
        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", true);
        desiredCapabilities.setCapability("selenoid:options", options);

        try {
            driver = new RemoteWebDriver(new URL("http://51.250.101.193:4444/wd/hub"), desiredCapabilities);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }


    //Подготовка локального веб-драйвера
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
