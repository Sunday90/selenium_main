package work.selenium.steps;

import work.selenium.pages.TasksPage;

public class TasksPageSteps {
    private TasksPage tasksPage = new TasksPage();

    public TasksPageSteps verifyThatLogonSuccessful() {
        tasksPage.assertThatLogonSuccessfull();
        return this;
    }

    public TasksPageSteps createTask(String title) {
        tasksPage.clickToCreateTaskButton();
        tasksPage.fillTaskTitleFull(title);
        return this;
    }

    public TasksPageSteps verifyThatTaskCreated() {
        tasksPage.assertThatTaskCreated();
        tasksPage.waitWhenCreatedTextBlockIsInvisible();
        return this;
    }

    public TasksPageSteps verifyThatTaskDateIsEmpty() {
        tasksPage.assertTaskDate("без даты");
        return this;
    }

}
