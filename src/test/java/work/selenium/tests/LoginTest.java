package work.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import work.selenium.steps.StartPageSteps;
import work.selenium.steps.TasksPageSteps;
import work.selenium.utils.DownloadThread;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LoginTest extends BaseTest {
    StartPageSteps steps;


    @BeforeClass
    public void beforeClassMethod() {
        steps = new StartPageSteps();
    }



    @Test
    public void testLogin() {
        steps.openLoginPage()
                .login("konstantin.plisov@softline.com", "123123")
                .verifyThatLogonSuccessful();
    }



    //Скачивание файла
//    @Test
//    public void testDownload() throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<HashMap<String, Long>> future = executorService.submit(new DownloadThread("https://www.7-zip.org/a/7z2107-x64.exe"));
//
//        Assert.assertTrue(future.get().get("7z2107-x64.exe") == 1533613L);
//
//        executorService.shutdown();
//    }
}
