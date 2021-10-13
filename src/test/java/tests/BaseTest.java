package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

public class BaseTest {

    String USER;
    String PASSWORD;

    @BeforeMethod
    public void setup () {
        Configuration.timeout = 60000;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "94.0.4606.61";
        Configuration.baseUrl = PropertyReader.getProperty("qase.url");
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        USER = PropertyReader.getProperty("qase.user");
        PASSWORD = PropertyReader.getProperty("qase.pass");
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
