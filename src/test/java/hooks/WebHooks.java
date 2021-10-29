package hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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


