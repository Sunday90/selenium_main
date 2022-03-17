package work.selenium.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import work.selenium.steps.StartPageSteps;

public class LoginTest extends BaseTest {
    StartPageSteps steps;

    @BeforeMethod
    public void beforeMethod() {
        steps = new StartPageSteps();
    }


    //Тест логина
    @Test
    public void testLogin() {
        steps.openLoginPage()
                .login("konstantin.plisov@softline.com", "123123")
                .verifyThatLogonSuccessful();
    }
}
