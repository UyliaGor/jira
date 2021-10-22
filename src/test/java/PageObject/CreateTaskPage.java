package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CreateTaskPage extends MainPage {

        @FindBy(how = How.XPATH, using = "//input[@id='issuetype-field']")
        private SelenideElement typeEpic;

        @FindBy(how = How.XPATH, using = "//input[@id='summary']")
        private SelenideElement topic;

        @FindBy(how = How.XPATH, using = "//select[@id='fixVersions']//option[@value='10001']")
        private SelenideElement versions;

        @FindBy(how = How.XPATH, using = "//input[@id='priority-field']")
        private SelenideElement priority;

        @FindBy(how = How.XPATH, using = "//div[@id='labels-multi-select']//textarea[@id='labels-textarea']")
        private SelenideElement label;

        @FindBy(how = How.XPATH, using = "//select[@id='versions']//option[@value='10001']")
        private SelenideElement vers;

        @FindBy(how = How.XPATH, using = "//a[@id='assign-to-me-trigger']")
        private SelenideElement author;

        @FindBy(how = How.XPATH, using = "//input[@id='create-issue-submit']")
        private SelenideElement buttonCreateTask;

        @FindBy(how = How.XPATH, using = "//a[@class='issue-created-key issue-link']")
        private SelenideElement linktoTask;

        @FindBy(how = How.XPATH, using = "//span[text()='В работе']")
        private SelenideElement buttonInwork;

        @FindBy(how = How.XPATH, using = "//span[@id='status-val']//span")
        private SelenideElement statusTask;

        @FindBy(how = How.XPATH, using = "//a[@id='opsbar-transitions_more']//span[@class='dropdown-text']")
        private SelenideElement dropdownStatusTask;

        @FindBy(how = How.XPATH, using = "//a[@class='issueaction-workflow-transition']//span[text()='Выполнено']")
        private SelenideElement doneStatusTask;

        @FindBy(how = How.XPATH, using = "//span[@id='status-val']//span[text()='Готово']")
        private SelenideElement checkdoneStatusTask;

        @FindBy(how = How.XPATH, using = "//a[@id='footer-comment-button']")
        private SelenideElement buttonComment;

        @FindBy(how = How.XPATH, using = "//input[@id='issue-comment-add-submit']")
        private SelenideElement buttonAddcomment;


        public CreateTaskPage selectTypetask() {
                typeEpic.click();
                typeEpic.sendKeys("Ошибка");
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage createTopicTask() {
                topic.click();
                topic.sendKeys("Ошибка АТ Фамилия");
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage createDescriptionTask(){
                Selenide.switchTo().defaultContent();
                SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id = 'description-wiki-edit']//iframe");
                Selenide.switchTo().frame(iframe);
                $x("//body[@id = 'tinymce']/p").sendKeys("Ошибка");
                Selenide.switchTo().defaultContent();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage selectVersionTask() {
                versions.click();
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage selectPriorityTask() {
                priority.click();
                priority.sendKeys("Low");
                priority.pressEnter();
               return page(CreateTaskPage.class);
        }
        public CreateTaskPage selectLabelTask() {
                label.click();
                label.sendKeys("blitz_test");
                label.pressEnter();
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage selectversTask() {
                vers.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage createEnvironmentTask(){
                Selenide.switchTo().defaultContent();
                SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id='environment-wiki-edit']//iframe");
                Selenide.switchTo().frame(iframe);
                $x("//body[@id = 'tinymce']/p").sendKeys("Windows 7");
                Selenide.switchTo().defaultContent();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage selectauthorTask() {
                author.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage createTask() {
                buttonCreateTask.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage goToCreatedTask() {
                linktoTask.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage clickToButtonInwork() {
                buttonInwork.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage checkStatusTask() {
                statusTask.shouldHave(text("В работе"));
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage changeStatusTask () {
                dropdownStatusTask.click();
                doneStatusTask.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage checkStatus() {
                checkdoneStatusTask.shouldHave(text("Готово"));
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage clickButtonComment() {
                buttonComment.click();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage createComment(){
                Selenide.switchTo().defaultContent();
                SelenideElement iframe = $x("//body/ancestor::html//iframe");
                Selenide.switchTo().frame(iframe);
                $x("//body[@id = 'tinymce']/p").sendKeys("Задание выполнено");
                Selenide.switchTo().defaultContent();
                return page(CreateTaskPage.class);
        }

        public CreateTaskPage addComment(){
                buttonAddcomment.click();
                return page(CreateTaskPage.class);
        }





}
