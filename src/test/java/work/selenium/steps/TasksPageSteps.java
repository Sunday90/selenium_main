package work.selenium.steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import work.selenium.pages.TasksPage;

public class TasksPageSteps extends BasePageSteps{
    private TasksPage tasksPage = new TasksPage();

    //Если появился аватар, значит сотрудник залогинился
    public TasksPageSteps verifyThatLogonSuccessful() {
        Assert.assertTrue(tasksPage.areAvatarsDisplayed());
        return this;
    }

    //Задача создана если появилась надпись что она создана и появилось поле комментария
    public TasksPageSteps verifyThatTaskCreated() {
        softAssert = new SoftAssert();
        softAssert.assertTrue(tasksPage.isTaskCreatedTextDisplayed());
        softAssert.assertTrue(tasksPage.isCommentInputDisplayed());
        softAssert.assertAll();
        tasksPage.waitWhenCreatedTextBlockIsInvisible();
        return this;
    }

    //Какой срок выбран
    public TasksPageSteps verifyTaskDate(String expectedDate) {
        Assert.assertEquals(tasksPage.getTaskDate(), expectedDate);
        return this;
    }

    //Пустая ли дата
    public TasksPageSteps verifyThatTaskDateIsEmpty() {
        return verifyTaskDate("без даты");
    }

    //На какого сотрудника назначена задача
    public TasksPageSteps verifyThatAssignedUserIsRight(String user) {
        Assert.assertEquals(tasksPage.getAssignedUserName().trim(), user);
        return this;
    }


    //Создать задачу
    public TasksPageSteps createTask(String title) {
        tasksPage.clickToCreateTaskButton();
        tasksPage.fillTaskTitleFull(title);
        return this;
    }

    //Поменять сотрудника на кого назначена задача
    public TasksPageSteps changeAssignedUser(String name) {
        tasksPage.clickToAssignedUserControl();
        tasksPage.fillSearchAssignedUserInput(name);
        tasksPage.selectUser(name);
        return this;
    }


}
