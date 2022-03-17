package work.selenium.steps;

import work.selenium.pages.StartPage;

public class StartPageSteps {
    private final StartPage startPage = new StartPage();

    public StartPageSteps openItself() {
        startPage.openItself();
        return this;
    }

    public LoginPageSteps openLoginPage() {
        startPage.clickToLoginButton();
        return new LoginPageSteps();
    }
}
