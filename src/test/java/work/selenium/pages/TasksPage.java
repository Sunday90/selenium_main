package work.selenium.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class TasksPage extends BasePage {

    //Верхний блок
    //Аватар сотрудника
    @FindBy(xpath = "//img[contains(@class, 'Avatar_photo')]")
    List<WebElement> avatarImgs;


    //Кнопка Запустить процесс
    @FindBy(xpath = "//div[@class='TasksMenu_start_process_oopKX']/button")
    WebElement startProcessBtn;

    //Нажатие на кнопку Запустить процесс
    public void clickToStartProcessButton() {
        startProcessBtn.click();
    }


    //Левый блок
    //Кнопка Создать задачу
    @FindBy(xpath = "//div[@class='TasksMenu_container_ZlIEU']/button")
    WebElement createTaskBtn;

    //Нажатие на кнопку Создать задачу
    public void clickToCreateTaskButton() {
        createTaskBtn.click();
    }


    //Блок с задачей
    //Надпись о том что задача создана
    @FindBy(xpath = "//div[contains(text(), 'Задача создана')]")
    WebElement taskCreatedText;

    public void waitWhenCreatedTextBlockIsInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(taskCreatedText));
    }


    //Статус задачи
    @FindBy(xpath = "//div[contains(@class, 'TaskCard_task_main')]//div[contains(@class, 'StatusInCard_status')]")
    WebElement taskStatus;

    public void clickToStatus() {
        taskStatus.click();
    }

    //Ссылка на задачу
    @FindBy(xpath = "//*[name()='svg' and contains(@class, 'TaskCard_link_icon')]")
    WebElement taskLink;

    //Меню
    @FindBy(xpath = "//*[name()='svg' and contains(@class, 'TaskCard_menu_icon')]")
    WebElement taskMenuControl;


    //Заголовок задачи
    @FindBy(xpath = "//div[contains(@class, 'TaskCard_title_text')]/textarea")
    WebElement taskTitle;

    //Заполнить заголовок задачи
    public void fillTaskTitleFull(String title) {
        taskTitle.sendKeys(title + Keys.ENTER);
    }


    //На кого назначена задача
    @FindBy(xpath = "//div[contains(@class, 'AssignedUser_container')]")
    WebElement assignedUserControl;

    //Выбранный срок задачи
    @FindBy(xpath = "//div[contains(@class, 'TaskCard_container')]//span[contains(@class, 'TaskDate_date_text')][1]")
    WebElement taskDate;

    //Кнопка добавить наблюдаталей
    @FindBy(xpath = "//button[contains(@class, 'TaskMembers_add_btn')]")
    WebElement addMembersBtn;

    //Кнопка создать описание
    @FindBy(xpath = "//button[contains(@class, 'TaskCard_add_description')]")
    WebElement addDescriptionBtn;

    //Кнопка создать подзадачи
    @FindBy(xpath = "//button[contains(@class, 'CheckList_add_checklist')]")
    WebElement createSubtasksBtn;

    //Кнопка прикрепить файлы
    @FindBy(xpath = "//div[contains(@class, 'TaskFiles_files')]//div[contains(@class, 'FileUploadMenu_external_add')]")
    WebElement fileUploadBtn;

    //Кнопка выбрать тип файлов
    @FindBy(xpath = "//div[contains(@class, 'TaskFiles_files')]//div[contains(@class, 'FileUploadMenu_external_dropdown')]")
    WebElement fileUploadChooseAnotherFileType;

    //Кнопка добавить ярлыки
    @FindBy(xpath = "//button[contains(@class, 'TaskTags_add_btn')]")
    WebElement addTagsBtn;


    //Поле комментария
    @FindBy(xpath = "//div[contains(@class, 'TaskComments_input_container')]//textarea")
    WebElement commentInput;


    //Если появился аватар, значит сотрудник залогинился
    public void assertThatLogonSuccessfull() {
        Assert.assertTrue(!avatarImgs.isEmpty());
    }

    //Задача создана если появилась надпись что она создана и появилось поле комментария
    public void assertThatTaskCreated() {
        Assert.assertTrue(taskCreatedText.isDisplayed());
        Assert.assertTrue(commentInput.isDisplayed());
    }

    //Какой срок выбран
    public void assertTaskDate(String expectedDate) {
        Assert.assertEquals(taskDate.getText().trim(), expectedDate);
    }

}
