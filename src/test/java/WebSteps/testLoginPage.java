package WebSteps;


import PageObject.LoginPage;
import com.codeborne.selenide.Selenide;
import hooks.Webhooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class testLoginPage extends Webhooks{
    String login = "gugorelikova",
           password = "123qaz!@#QAZ",
           typeproject = "Test",
           task = "TestSelenium",
           topictask = "Ошибка АТ Фамилия",
            labelTask = "blitz_test";

    @DisplayName("Авторизация")
    @Test

    public void autorizeJira(){
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", LoginPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin();
    }
    @DisplayName("Проверка задачи в проекте")
    @Test

    public void testTaskProgect() {
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", LoginPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin()
                .clickTobuttonProject()
                .viewAllProject()
                .searchProject(typeproject)
                .goToProject()
                .goToTask()
                .buttonFilterTask()
                .selectTask()
                .checkCountTask()
                .searchTaskbyText(task)
                .checkStatusTest()
                .checkVersion();

    }
    @DisplayName("Создание задачи")
    @Test

    public void testCreateTask() {
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", LoginPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin()
                .clickToCreatetask()
                .selectTypetask()
                .createTopicTask()
                .createDescriptionTask()
                .selectVersionTask()
                .selectPriorityTask()
                .selectLabelTask()
                .selectversTask()
                .createEnvironmentTask()
                .selectauthorTask()
                .createTask()
                .goToCreatedTask()
                .clickToButtonInwork()
                .checkStatusTask()
                .changeStatusTask ()
                .checkStatus()
                .clickButtonComment()
                .createComment()
                .addComment();

    }


}
