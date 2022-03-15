package work.selenium.pages;

import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TasksPage extends BasePage {

    //Верхний блок
    //Аватар сотрудника
    @FindBy(xpath = "//img[contains(@class, 'Avatar_photo')]")
    List<WebElement> avatarImgs;

    public boolean areAvatarsDisplayed() {
        return !avatarImgs.isEmpty();
    }


    //Левый блок
    //Кнопка Запустить процесс
    @FindBy(xpath = "//div[@class='TasksMenu_start_process_oopKX']/button")
    WebElement startProcessBtn;

    //Нажатие на кнопку Запустить процесс
    public void clickToStartProcessButton() {
        startProcessBtn.click();
    }


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

    public boolean isTaskCreatedTextDisplayed() {
        return taskCreatedText.isDisplayed();
    }

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

    public void fillTaskTitleFull(String title) {
        taskTitle.sendKeys(title + Keys.ENTER);
    }


    //На кого назначена задача
    @FindBy(xpath = "//div[contains(@class, 'AssignedUser_container')]//div[contains(@class, 'AssignedUser_name')]")
    WebElement assignedUserControl;

    public String getAssignedUserName() {
        return assignedUserControl.getText();
    }

    public void clickToAssignedUserControl() {
        assignedUserControl.click();
    }


    //Поле поиска по сотрудникам
    @FindBy(xpath = "//input[contains(@id, 'searchinput')]")
    WebElement searchAssignedUserInput;

    public void fillSearchAssignedUserInput(String text) {
        searchAssignedUserInput.sendKeys(text);
    }


    //Найденные сотрудники (контролы)
    @FindBy(xpath = "//div[contains(@class, 'SelectUser_menu_wrapper')]//div[contains(@class, 'SelectUser_user_item')]")
    List<WebElement> usersControls;

    //Имя сотрудника
    String getUserName(WebElement element) {
        By userNameDiv = By.xpath("//div[contains(@class, 'UserInMenu_name')]");
        return element.findElement(userNameDiv).getText();
    }

    //Загрузка поиска по сотрудникам
    @FindBy(xpath = "//div[contains(@class, 'Loader_centered')]")
    WebElement findUsersLoader;

    //Ждем пока сработает загрузка поиска
    public void waitFindUsersLoaderWork() {
        wait.until(ExpectedConditions.visibilityOf(findUsersLoader));
        wait.until(ExpectedConditions.invisibilityOf(findUsersLoader));
    }

    //Найдены ли сотрудники
    public boolean areUsersFound() {
        return usersControls.isEmpty();
    }

    //Выбрать сотрудника из найденных
    public void selectUser(String name) {
        waitFindUsersLoaderWork();

        usersControls.stream().filter(user -> getUserName(user).trim().equals(name))
                .forEach(user -> user.click());
    }



    //Блок с выбором срока задачи
    // Выбранный срок задачи в карточке
    @FindBy(xpath = "//div[contains(@class, 'TaskCard_container')]//span[contains(@class, 'TaskDate_date_text')][1]")
    WebElement taskDate;

    public String getTaskDate() {
        return taskDate.getText().trim();
    }

    public void clickToTaskDateControl() {
        taskDate.click();
    }


    




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

    public boolean isCommentInputDisplayed() {
        return commentInput.isDisplayed();
    }

}
