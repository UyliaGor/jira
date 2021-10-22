package WebSteps;

import PageObject.CreateTaskPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class proverka {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;

    }

    @Test
    public void main() {
        // открываем cтраницу
        open("https://edujira.ifellow.ru/secure/Dashboard.jspa");
        // заполняем форму
        $x("//input[@id='login-form-username']").sendKeys("gugorelikova");
        $x("//input[@id='login-form-password']").sendKeys("123qaz!@#QAZ");
        $x("//div[@class='buttons']//input[@id='login']").click();
        $x("//a[@id='create_link']").click();
        $x("//input[@id='issuetype-field']").click();
        $x("//input[@id='issuetype-field']").sendKeys("Ошибка");
        $x("//input[@id='issuetype-field']").pressEnter();
        $x("//input[@id='summary']").click();
        $x("//input[@id='summary']").sendKeys("Ошибка АТ Фамилия");
        Selenide.switchTo().defaultContent();
        SelenideElement iframe = $x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id = 'description-wiki-edit']//iframe");
        Selenide.switchTo().frame(iframe);
        $x("//body[@id = 'tinymce']/p").sendKeys("Ошибка");
        Selenide.switchTo().defaultContent();
        $x("//select[@id='fixVersions']//option[@value='10001']").click();
        $x("//input[@id='priority-field']").click();
        $x("//input[@id='priority-field']").sendKeys("Low");
        $x("//input[@id='priority-field']").pressEnter();
        $x("//div[@id='labels-multi-select']//textarea[@id='labels-textarea']").click();
        $x("//div[@id='labels-multi-select']//textarea[@id='labels-textarea']").sendKeys("blitz_test");
        $x("//div[@id='labels-multi-select']//textarea[@id='labels-textarea']").pressEnter();
        $x("//select[@id='versions']//option[@value='10001']").click();
        Selenide.switchTo().defaultContent();
        //$x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id='environment-wiki-edit']//iframe");
        Selenide.switchTo().frame($x("//body['#aui-layout aui-theme-default ka ajax-issue-search-and-view page-type-navigator page-type-split']/ancestor::html[@class = 'webkit chrome']//div[@class = 'jira-wikifield']//div[@id='environment-wiki-edit']//iframe"));
        $x("//body[@id = 'tinymce']/p").sendKeys("Windows 7");
        Selenide.switchTo().defaultContent();
        $x("//a[@id='assign-to-me-trigger']").click();
        $x("//input[@id='create-issue-submit']").click();
        $x("//a[@class='issue-created-key issue-link']").click();
        $x("//span[text()='В работе']").click();
        $x("//span[@id='status-val']//span").shouldHave(text("В работе"));
        $x("//a[@id='opsbar-transitions_more']//span[@class='dropdown-text']").click();
        $x("//a[@class='issueaction-workflow-transition']//span[text()='Выполнено']").click();
        $x("//span[@id='status-val']//span[text()='Готово']").shouldHave(text("Готово"));
        $x("//a[@id='footer-comment-button']").click();
        Selenide.switchTo().defaultContent();
        Selenide.switchTo().frame($x("//body/ancestor::html//iframe"));
        $x("//body[@id = 'tinymce']/p").sendKeys("Задание выполнено");
        Selenide.switchTo().defaultContent();
        $x("//input[@id='issue-comment-add-submit']").click();





    }
}
