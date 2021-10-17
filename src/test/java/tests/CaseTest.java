package tests;

import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest{

    TestCase testcase;

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, pass)
                .openProject("This project")
                .clickCreateCase()
                .fillTestCase(testcase = TestCaseFactory.get())
                .saveTestCase();
        //validate case info
    }
}
