package WebSteps;


import PageObject.CreateTaskPage;
import PageObject.LoginPage;
import PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import sun.tools.jar.Main;

import static java.nio.channels.SocketChannel.open;

public class testLoginPage {
    String login = "gugorelikova",
           password = "123qaz!@#QAZ",
           typeproject = "Test",
           task = "TestSelenium",
           topictask = "Ошибка АТ «Фамилия»",
            descriptionTask = "Ошибка АТ «Фамилия»";
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void autorizeJira(){
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", LoginPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin()
                .should_be_authorized_user();
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
                .checkStatus()
                .checkVersion();

    }
    @Test
    public void testCreateTask() {
        Selenide.open("https://edujira.ifellow.ru/secure/Dashboard.jspa", MainPage.class)
                .clickToValUserName(login)
                .clickToValPassWord(password)
                .clickToCheckbox()
                .clickButtonLogin()
                .clickToCreatetask()
                .selectTypetask()
                .createTopicTask(topictask)
               .createDescriptionTask(descriptionTask);
    }
    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }

}
