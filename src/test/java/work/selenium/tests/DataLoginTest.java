package work.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import work.selenium.steps.StartPageSteps;
import work.selenium.utils.ExcelReader;

public class DataLoginTest {
    StartPageSteps steps;

    @DataProvider(name = "loginsDataProvider")
    public Object[][] getLoginData() {
        ExcelReader.setExcelSheet("Login data");
        return ExcelReader.getTestData("Correct logins");
    }


    @BeforeMethod
    public void beforeMethod() {
        BaseTest.setUp();
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
