package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class CreateTaskPage extends MainPage {
        @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
        private SelenideElement createLink;

        @FindBy(how = How.XPATH, using = "//div[@id='issuetype-single-select']//span[contains(@class, 'icon aui-ss-icon')]")
        private SelenideElement dropdownType;

        @FindBy(how = How.XPATH, using = "//li[@class='aui-list-item aui-list-item-li-epic']")
        private SelenideElement typeEpic;

        @FindBy(how = How.XPATH, using = "//input[@id='summary']")
        private SelenideElement topic;

        @FindBy(how = How.XPATH, using = "//div[@id='description-wiki-edit']//div[@class='rte-container']")
        private SelenideElement description;

        public CreateTaskPage  clickToCreatetask() {
                createLink.click();
                return page(CreateTaskPage .class);
        }
        public CreateTaskPage selectTypetask() {
                dropdownType.click();
                typeEpic.click();
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage createTopicTask(String topictask) {
                topic.click();
                topic.val(topictask);
                topic.pressEnter();
                return page(CreateTaskPage.class);
        }
        public CreateTaskPage createDescriptionTask(String descriptionTask) {
                description.click();
                description.val(descriptionTask);
                description.pressEnter();
                return page(CreateTaskPage.class);
        }




}
