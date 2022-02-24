package work.selenium.tests;

import org.testng.Assert;
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
    @Test(priority = 0)
    public void testLogin() {
        new StartPageSteps().openLoginPage()
                .login("konstantin.plisov@softline.com", "123123")
                .verifyThatLogonSuccessful();
    }

    @Test(priority = 1)
    public void testThatTaskCreated() {
        new TasksPageSteps().createTask("Task1")
                .verifyThatTaskCreated();
    }

    @Test(priority = 2)
    public void testThatTaskDateIsEmpty() {
        new TasksPageSteps().createTask("Task1")
                .verifyThatTaskDateIsEmpty();
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
