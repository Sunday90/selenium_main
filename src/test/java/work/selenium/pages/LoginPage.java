package work.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final String loginButton = "//button[contains(@class, 'LoginForm_btn_12EDO')]";
    private final String forgotPasswordLink = "LoginForm_forgot_link_35eaq";

    //Первая форма входа email
    //Поле ввода email
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }


    //Первая кнопка войти
    @FindBy(xpath = loginButton)
    WebElement firstLoginButton;

    public void clickToFirstLoginButton() {
        firstLoginButton.click();
    }


    //Сообщение нет такого пользователя
    @FindBy(className = "TextInput_error_msg_BM10C")
    WebElement noSuchUserMessageDiv;

    //Первая ссылка восстановить пароль
    @FindBy(className = forgotPasswordLink)
    WebElement firstForgotPasswordLink;






    //Вторая форма ввода пароля
    //Войти под другим email
    @FindBy(className = "LoginForm_another_email_39tmJ")
    WebElement backToEmailLink;

    //Поле ввода пароля
    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordInput;

    public void fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }


    //Вторая кнопка войти
    @FindBy(xpath = loginButton)
    WebElement secondLoginButton;

    public void clickToSecondLoginButton() {
        secondLoginButton.click();
    }


    //Вторая ссылка восстановить пароль
    @FindBy(className = forgotPasswordLink)
    WebElement secondForgotPasswordLink;






    //Форма восстановления пароля
    //Поле ввода email
    @FindBy(xpath = "//input[@type='text']")
    WebElement forgotEmailInput;

    public void fillForgotEmailInput(String email) {
        forgotEmailInput.sendKeys(email);
    }


    //Кнопка отправки письма
    @FindBy(xpath = "//button[contains(@class, 'PasswordRecoveryForm_btn_vpraj')]")
    WebElement sendEmailButton;

    public void clickToSendEmailButton() {
        sendEmailButton.click();
    }


    //Сообщение что письмо отправлено
    @FindBy(className = "PasswordRecoveryForm_info_1JNHY")
    WebElement passwordSentDiv;

}
