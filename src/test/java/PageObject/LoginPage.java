package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement UserName;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement PassWord;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-remember-me']")
    private SelenideElement CheckboxRemember;

    @FindBy(how = How.XPATH, using = "//div[@class='buttons']//input[@id='login']")
    private SelenideElement buttonLogin;

    @FindBy(how = How.XPATH, using = "//div[@class='aui-page-header-main']/h1")
    private SelenideElement successfulRegistr;

    public MainPage clickToValUserName(String login){
        UserName.click();
        UserName.sendKeys(login);
        return page(MainPage.class);
    }
    public MainPage clickToValPassWord(String password) {
        PassWord.click();
        PassWord.sendKeys(password);
        return page(MainPage.class);
    }
    public MainPage clickToCheckbox() {
        CheckboxRemember.click();
        return page(MainPage.class);
    }
    public MainPage clickButtonLogin() {
        buttonLogin.click();
        return page(MainPage.class);
    }
    public MainPage should_be_authorized_user(){
        successfulRegistr.shouldHave(text("System Dashboard"));
        return page(MainPage.class);
    }
}
