package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

public class BaseTest {

    String user;
    String pass;

    @BeforeMethod
    public void setup () {
        Configuration.baseUrl = System.getenv().getOrDefault("QASE_URL",
                PropertyReader.getProperty("qase.url"));
        user = System.getenv().getOrDefault("QASE_USER",
                PropertyReader.getProperty("qase.user"));
        pass = System.getenv().getOrDefault("QASE_PASS",
                PropertyReader.getProperty("qase.pass"));
        Configuration.timeout = 60000;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "94.0.4606.81";
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = false;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.close();
    }
}
