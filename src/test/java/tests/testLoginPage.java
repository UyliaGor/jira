package tests;


import PageObject.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class testLoginPage {
    String login = "gugorelikova",
           password = "123qaz!@#QAZ",
           typeproject = "Test",
           task = "TestSelenium",
           topictask = "Ошибка АТ Фамилия",
            labelTask = "blitz_test";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void autorizeJira(){
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", LoginPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin();
    }
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
