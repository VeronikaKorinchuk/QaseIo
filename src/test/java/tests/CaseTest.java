package tests;

import models.TestCase;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest{

    TestCase caseForm;

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login("vvv.zenkevich@gmail.com", "password03")
                .openProject("This project")
                .clickCreateCase()
                .fillNewCaseForm();
        //validate case info
    }
}
