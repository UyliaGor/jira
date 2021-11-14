package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class WebHooks {
    @Before
    public void setup(){
    Configuration.startMaximized = true;
    Configuration.timeout = 10000;
    }

    @After
    public void driverClose() {WebDriverRunner.closeWebDriver();
    }
}


