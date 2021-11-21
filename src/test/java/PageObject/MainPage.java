package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends LoginPage {
    @FindBy(how = How.XPATH, using = "//a[@id='browse_link']")
    private SelenideElement buttonprojects;

    @FindBy(how = How.XPATH, using = "//a[@id='project_view_all_link_lnk']")
    private SelenideElement buttonallprojects;

    @FindBy(how = How.XPATH, using = "//input[@id='project-filter-text']")
    private SelenideElement searchprojects;

    @FindBy(how = How.XPATH, using = "//td[@class='cell-type-name']//a[@title='Test']")
    private SelenideElement linkproject;

    @FindBy(how = How.XPATH, using = "//a[@class='aui-nav-item ' ]//span[text()='Задачи']")
    private SelenideElement tasklist;

    @FindBy(how = How.XPATH, using = "//button[@id='subnav-trigger']")
    private SelenideElement filtertask;

    @FindBy(how = How.XPATH, using = "//a[@class='aui-dropdown2-radio'][text()='Все задачи']")
    private SelenideElement buttonalltask;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'1 из')]")
    private SelenideElement counttask;

    @FindBy(how = How.XPATH, using = "//input[@id='quickSearchInput']")
    private SelenideElement searchform;

    @FindBy (how = How.XPATH, using = "//span[@id='status-val']//span")
    private SelenideElement checkStatustest;

    @FindBy (how = How.XPATH, using = "//span[text()='Version 2.0']")
    private SelenideElement checkVersion;

    @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
    private SelenideElement createLink;

    @Step("переход в проекты")
    public CreateTaskPage clickTobuttonProject() {
        buttonprojects.click();
        return page(CreateTaskPage.class);
    }
    @Step("просмотр всех проектов")
    public CreateTaskPage viewAllProject() {
        buttonallprojects.click();
        return page(CreateTaskPage.class);
    }
    @Step("выбор типа проекта")
    public CreateTaskPage searchProject(String typeproject) {
        searchprojects.click();
        searchprojects.sendKeys(typeproject);
        return page(CreateTaskPage.class);
    }
    @Step("переход в выбранный проект")
    public CreateTaskPage goToProject() {
        linkproject.click();
        return page(CreateTaskPage.class);
    }
    @Step("переход в задачу")
    public CreateTaskPage goToTask() {
        tasklist.click();
        return page(CreateTaskPage.class);
    }
    @Step("фильтрация задач")
    public CreateTaskPage buttonFilterTask() {
        filtertask.click();
        return page(CreateTaskPage.class);
    }
    @Step("выбор задачи")
    public CreateTaskPage selectTask() {
        buttonalltask.click();
        return page(CreateTaskPage.class);
    }
    @Step("проверка количества задач")
    public CreateTaskPage checkCountTask() {
        String
                 text = counttask.text(),
                 probel = "из";
        int x1 = text.indexOf(probel), y = text.length();
        String word = text.substring(x1+2, y);
        System.out.println(word);
        return page(CreateTaskPage.class);

    }
    @Step("поиск задачи по тексту")
    public CreateTaskPage searchTaskbyText(String task){
        searchform.click();
        searchform.sendKeys(task);
        searchform.pressEnter();
        return page(CreateTaskPage.class);
    }
    @Step("проверка статуса у задачи")
    public CreateTaskPage checkStatusTest() {
        checkStatustest.shouldBe(visible);
        return page(CreateTaskPage.class);
    }
    @Step("проверка версии у задачи")
    public CreateTaskPage checkVersion() {
        checkVersion.shouldHave(text("Version 2.0"));
        return page(CreateTaskPage.class);
    }
    @Step("клик по кнопки создание задачи")
    public CreateTaskPage clickToCreatetask() {
        createLink.click();
        return page(CreateTaskPage.class);
    }

}
