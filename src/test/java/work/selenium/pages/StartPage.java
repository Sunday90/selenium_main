package work.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import work.selenium.utils.PropertyReader;

public class StartPage extends BasePage {
    //Кнопка войти
    @FindBy(className = "btn-login")
    WebElement loginBtn;

    public void openItself() {
        driver.get(PropertyReader.getBaseUrl());
    }

    public void clickToLoginButton() {
        loginBtn.click();
    }
}
