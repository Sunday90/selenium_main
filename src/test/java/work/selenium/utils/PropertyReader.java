package work.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static final String pathToPropertiesFile = "src/test/resources/framework.properties";

    public static String getBaseUrl() {
        return getProperty("url");
    }

    public static Browser getBrowser() {
        return Browser.valueOf(getProperty("browser"));
    }


    public static String getProperty(String propertyName) {
        if (System.getProperty(propertyName) == null) {
            return getPropertyFromFile(propertyName);
        } else {
            return System.getProperty(propertyName);
        }
    }

    public static String getPropertyFromFile(String propertyName) {
        Properties prop = new Properties();
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(pathToPropertiesFile);
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Cannot read property value for " + propertyName);
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop.getProperty(propertyName);
    }
}
