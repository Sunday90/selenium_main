package work.selenium.tests;

import org.testng.annotations.*;
import work.selenium.steps.StartPageSteps;
import work.selenium.utils.ExcelReader;

public class DataLoginTest {
    StartPageSteps steps;

    @DataProvider(name = "loginsDataProvider")
    public Object[][] getLoginData() {
        ExcelReader.setExcelSheet("Login data");
        return ExcelReader.getTestData("Correct logins");
    }


    @Parameters({"platform", "browser", "version", "url"})
    @BeforeMethod
    public void beforeMethod(String platform, String browser, String version, String url) {
        BaseTest.setUp(platform, browser, version, url, Boolean.toString(true));
        steps = new StartPageSteps();
    }


    //Тест логинов
    @Test(dataProvider = "loginsDataProvider")
    public void testLogin(String userName, String password) {
        steps.openLoginPage()
                .login(userName, password)
                .verifyThatLogonSuccessful()
                .logout();
    }

    @AfterMethod
    public void afterMethod() {
        BaseTest.tearDown();
    }
}
