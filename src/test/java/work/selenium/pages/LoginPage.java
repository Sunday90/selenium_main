package work.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final String loginButton = "//button[contains(@class, 'LoginForm_btn_12EDO')]";
    private final String forgotPasswordLink = "LoginForm_forgot_link_35eaq";

    //Первая форма входа email
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = loginButton)
    WebElement firstLoginButton;

    @FindBy(className = "TextInput_error_msg_BM10C")
    WebElement noSuchUserMessageDiv;

    @FindBy(className = forgotPasswordLink)
    WebElement firstForgotPasswordLink;


    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }

    public void clickToFirstLoginButton() {
        firstLoginButton.click();
    }



    //Вторая форма ввода пароля
    @FindBy(className = "LoginForm_another_email_39tmJ")
    WebElement backToEmailLink;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordInput;

    @FindBy(xpath = loginButton)
    WebElement secondLoginButton;

    @FindBy(className = forgotPasswordLink)
    WebElement secondForgotPasswordLink;


    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickToSecondLoginButton() {
        secondLoginButton.click();
    }



    //Форма восстановления пароля
    @FindBy(xpath = "//input[@type='text']")
    WebElement forgotEmailInput;

    @FindBy(xpath = "//button[contains(@class, 'PasswordRecoveryForm_btn_vpraj')]")
    WebElement sendEmailButton;

    @FindBy(className = "PasswordRecoveryForm_info_1JNHY")
    WebElement passwordSentDiv;


    public void fillForgotEmailInput(String email) {
        forgotEmailInput.sendKeys(email);
    }

    public void clickToSendEmailButton() {
        sendEmailButton.click();
    }

}
