package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static jdk.nashorn.internal.objects.NativeString.substring;

public class MainPage extends LoginPage {
    @FindBy(how = How.XPATH, using = "//a[@id='browse_link']")
    private SelenideElement buttonprojects;

    @FindBy(how = How.XPATH, using = "//a[@id='project_view_all_link_lnk']")
    private SelenideElement buttonallprojects;

    @FindBy(how = How.XPATH, using = "//input[@id='project-filter-text']")
    private SelenideElement searchprojects;

    @FindBy(how = How.XPATH, using = "//td[@class='cell-type-name']//a[@title='Test']") //конкретность ввода
    private SelenideElement linkproject;

    @FindBy(how = How.XPATH, using = "//a[@class='aui-nav-item ' ]//span[text()='Задачи']")
    private SelenideElement tasklist;

    @FindBy(how = How.XPATH, using = "//button[@id='subnav-trigger']")
    private SelenideElement filtertask;

    @FindBy(how = How.XPATH, using = "//a[@class='aui-dropdown2-radio'][text()='Все задачи']")
    private SelenideElement buttonalltask;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'1 из')]")
    private SelenideElement counttask;

    // @FindBy(how = How.XPATH, using = "//span[text()='Задачи']")
    //private SelenideElement buttontasks;

    @FindBy(how = How.XPATH, using = "//input[@id='quickSearchInput']")
    private SelenideElement searchform;

    @FindBy (how = How.XPATH, using = "//span[@id='status-val']//span")
    private SelenideElement checkStatus;

    @FindBy (how = How.XPATH, using = "//span[text()='Version 2.0']")
    private SelenideElement checkVersion;




    // @FindBy(how = How.XPATH, using = "//li[@id='issues_new_search_link']")
    // private SelenideElement buttonsearchtasks;

    // @FindBy(how = How.XPATH, using = "//input[@id='searcher-query']")
    // private SelenideElement searchtaskstext;




    public MainPage clickTobuttonProject() {
        buttonprojects.click();
        return page(MainPage.class);
    }
    public MainPage viewAllProject() {
        buttonallprojects.click();
        return page(MainPage.class);
    }

    public MainPage searchProject(String typeproject) {
        searchprojects.click();
        searchprojects.sendKeys(typeproject);
        return page(MainPage.class);
    }
    public MainPage goToProject() {
        linkproject.click();
        return page(MainPage.class);
    }
    public MainPage goToTask() {
        tasklist.click();
        return page(MainPage.class);
    }
    public MainPage buttonFilterTask() {
        filtertask.click();
        return page(MainPage.class);
    }
    public MainPage selectTask() {
        buttonalltask.click();
        return page(MainPage.class);
    }
    public MainPage checkCountTask() {
        String
                 text = counttask.text(),
                 probel = "из";
        int x1 = text.indexOf(probel), y = text.length();
        String word = text.substring(x1+2, y);
        System.out.println(word);
        return page(MainPage.class);

    }
    //public MainPage clickTobuttonTasks(){
       // buttontasks.click();
        //buttonsearchtasks.click();
        //return page(MainPage.class);
    //}


    public MainPage searchTaskbyText(String task){
        searchform.click();
        searchform.sendKeys(task);
        searchform.pressEnter();
        return page(MainPage.class);
    }

    public MainPage checkStatus() {
        checkStatus.shouldBe(visible);
        return page(MainPage.class);
    }

    public MainPage checkVersion() {
        checkVersion.shouldHave(text("Version 2.0"));
        return page(MainPage.class);
    }






}
