package work.selenium.steps;

import work.selenium.pages.LoginPage;

public class LoginPageSteps {
private LoginPage loginPage = new LoginPage();

    public LoginPageSteps login(String email, String password) {
        loginPage.fillEmailInput(email);
        loginPage.clickToFirstLoginButton();
        loginPage.fillPasswordInput(password);
        loginPage.clickToSecondLoginButton();
        return this;
    }
}
