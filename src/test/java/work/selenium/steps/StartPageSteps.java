package work.selenium.steps;

import work.selenium.pages.StartPage;

public class StartPageSteps {
    private StartPage startPage = new StartPage();

    public LoginPageSteps openLoginPage() {
        startPage.clickToLoginButton();
        return new LoginPageSteps();
    }
}
