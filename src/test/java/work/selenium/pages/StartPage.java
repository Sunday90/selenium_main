package work.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage {
    //Кнопка войти
    @FindBy(className = "btn-login")
    WebElement loginBtn;

    public void clickToLoginButton() {
        loginBtn.click();
    }
}
