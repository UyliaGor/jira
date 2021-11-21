package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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

    @Step("ввод логина")
    public MainPage clickToValUserName(String login){
        UserName.click();
        UserName.sendKeys(login);
        return page(MainPage.class);
    }
    @Step("ввод пароля")
    public MainPage clickToValPassWord(String password) {
        PassWord.click();
        PassWord.sendKeys(password);
        return page(MainPage.class);
    }
    @Step("запомнить уз")
    public MainPage clickToCheckbox() {
        CheckboxRemember.click();
        return page(MainPage.class);
    }
    @Step("войти")
    public MainPage clickButtonLogin() {
        buttonLogin.click();
        return page(MainPage.class);
    }

}
