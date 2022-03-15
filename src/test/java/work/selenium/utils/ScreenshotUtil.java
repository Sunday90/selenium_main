package work.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.CuttingDecorator;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    private static Screenshot screenshot;
    private static final String imageType = "jpg";


    //Запись изображения
    private static void writeImage(String fileName) {
        try {
            String filePath = System.getProperty("user.dir") + "/src/screenshots/" + fileName + "." + imageType;
            ImageIO.write(screenshot.getImage(), imageType, new File(filePath));
            System.out.println("Screen wrote. " + filePath);
        }
        catch (IOException e)
        {
            System.out.printf("Не удалось записать изображение %s.%s", fileName, imageType);
            e.printStackTrace();
        }
    }




    //Скриншот страницы размером с разрешение экрана
    public static void getScreenSizePageScreenshot(WebDriver driver, String fileName) {
        screenshot = new AShot().takeScreenshot(driver);
        writeImage(fileName);
    }

    //Скриншот полной страницы
    public static void getFullPageScreenshot(WebDriver driver, String fileName) {
        screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        writeImage(fileName);
    }

    //Скриншот веб-элемента
    public static void getWebElementScreenshot(WebDriver driver, WebElement element, String fileName) {
        screenshot = new AShot().takeScreenshot(driver, element);
        writeImage(fileName);
    }
}
