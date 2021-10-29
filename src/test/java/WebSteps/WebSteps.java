package WebSteps;

import PageObject.CreateTaskPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class WebSteps  {
    @Дано("^Открываем главную страницу Jira$")
    public void openJira() {
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
    }

    @И("^Вводим логин$")
    public void enterLogin(List<String> testdata) {
        String login = testdata.get(0);
        page(LoginPage.class).clickToValUserName(login);
    }

    @И("^Вводим пароль$")
    public void enterPassword(List<String> testdata) {
        String password = testdata.get(0);
        page(LoginPage.class).clickToValPassWord(password);
        page(LoginPage.class).clickButtonLogin();
    }

    @И("^Проверяем общее количество заведенных задач в проекте TestProject$")
    public void checkCounttasks(List<String> testdata) {
        String typeproject = testdata.get(0);
        page(MainPage.class).clickTobuttonProject();
        page(MainPage.class).viewAllProject();
        page(MainPage.class).searchProject(typeproject);
        page(MainPage.class).goToProject();
        page(MainPage.class).goToTask();
        page(MainPage.class).buttonFilterTask();
        page(MainPage.class).selectTask();
        page(MainPage.class).checkCountTask();
    }
    @И("^Проверяем статус и версию задачи TestSelenium$")
    public void checkStatustasks(List<String> testdata) {
        String task = testdata.get(0);
        page(MainPage.class).searchTaskbyText(task);
        page(MainPage.class).checkStatusTest();
        page(MainPage.class).checkVersion();
    }
    @И("^Создаем новую задачу$")
    public void createTask() {
        page(CreateTaskPage.class).clickToCreatetask();
        page(CreateTaskPage.class).selectTypetask();
        page(CreateTaskPage.class).createTopicTask();
        page(CreateTaskPage.class).createDescriptionTask();
        page(CreateTaskPage.class).selectVersionTask();
        page(CreateTaskPage.class).selectPriorityTask();
        page(CreateTaskPage.class).selectLabelTask();
        page(CreateTaskPage.class).selectversTask();
        page(CreateTaskPage.class).createEnvironmentTask();
        page(CreateTaskPage.class).selectauthorTask();
        page(CreateTaskPage.class).createTask();
    }
    @И("^Проверяем перевод задачи в разные статусы$")
    public void checkDifferentstatusTask() {
        page(CreateTaskPage.class).goToCreatedTask();
        page(CreateTaskPage.class).clickToButtonInwork();
        page(CreateTaskPage.class).checkStatusTask();
        page(CreateTaskPage.class).changeStatusTask();
        page(CreateTaskPage.class).checkStatus();
    }
    @И("^Добавляем комментарий об исполнении задачи$")
    public void addCommitTask() {
        page(CreateTaskPage.class).clickButtonComment();
        page(CreateTaskPage.class).createComment();
        page(CreateTaskPage.class).addComment();
    }
}