package work.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import work.selenium.steps.StartPageSteps;
import work.selenium.steps.TasksPageSteps;

public class TasksTest extends BaseTest {
    TasksPageSteps steps;


    @BeforeClass
    public void beforeClassMethod() {
        steps = new TasksPageSteps();
    }

    @Test(priority = 0)
    public void testThatTaskCreated() {
        steps.createTask("Task1")
                .verifyThatTaskCreated();
    }

    @Test(dependsOnMethods = "testThatTaskCreated")
    public void testThatTaskCreatedRight() {
        steps.verifyThatTaskDateIsEmpty()
                .verifyThatAssignedUserIsRight("Константин Плисов");
    }

    @Test(dependsOnMethods = "testThatTaskCreatedRight")
    public void testThatAssignedUserChangesRight() {
        String name = "Сотрудник 21 Тестовый";
        steps.changeAssignedUser(name)
                .verifyThatAssignedUserIsRight(name);
    }

}
