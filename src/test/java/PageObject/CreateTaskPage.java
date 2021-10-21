package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CreateTaskPage extends MainPage {
        @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
        private SelenideElement createLink;

        @FindBy(how = How.XPATH, using = "//input[@id='issuetype-field']")
        private SelenideElement typeEpic;

        @FindBy(how = How.XPATH, using = "//input[@id='summary']")
        private SelenideElement topic;

        //@FindBy(how = How.XPATH, using = "//div[@id='description-wiki-edit']//div[@class='rte-container']")
        //private SelenideElement description;

        @FindBy(how = How.XPATH, using = "//input[@id='priority-field']")
        private SelenideElement priority;

        @FindBy(how = How.XPATH, using = "//div[@id='labels-multi-select']//textarea[@id='labels-textarea']")
        private SelenideElement label;

        @FindBy(how = How.XPATH, using = "//div[@id='assignee-single-select']//input")
        private SelenideElement author;


        // //input[@id="create-issue-submit"] - xpath кнопки создать

        public CreateTaskPage  clickToCreatetask() {
                createLink.click();
                return page(CreateTaskPage .class);
        }
        public CreateTaskPage selectTypetask() {
                typeEpic.click();
                typeEpic.sendKeys("Ошибка");
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage createTopicTask(String topictask) {
                topic.sendKeys(topictask);
                topic.pressEnter();
                return page(CreateTaskPage.class);
        }
        //public CreateTaskPage createDescriptionTask(String descriptionTask) {
               // description.click();
                //description.val(descriptionTask);
                //description.pressEnter();
                //return page(CreateTaskPage.class);
       // }
        public CreateTaskPage selectPriorityTask() {
                priority.click();
               priority.sendKeys("Highest");
               priority.pressEnter();
               return page(CreateTaskPage.class);
        }
        public CreateTaskPage selectLabelTask(String labelTask) {
                label.click();
                label.val(labelTask);
                label.pressEnter();
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage selectauthorTask(String authorTask) {
                author.click();
                author.val(authorTask);
                author.pressEnter();
                return page(CreateTaskPage.class);
        }




}
