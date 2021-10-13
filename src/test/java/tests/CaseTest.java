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
                .login(USER, PASSWORD)
                .openProject("This project")
                .clickCreateCase()
                .fillNewCaseForm(testcase = TestCaseFactory.get());
        //validate case info
    }
}
