package work.selenium.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLogin() {
        steps.openLoginPage().login("konstantin.plisov@softline.com", "Positiveway1");
    }
}
