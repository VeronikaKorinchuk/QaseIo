package tests;

import models.CaseForm;
import models.CaseFormFactory;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest{

    CaseForm caseForm;

    @Test
    public void testCaseShouldBeCreated() {
        new LoginPage()
                .open()
                .login("vvv.zenkevich@gmail.com", "password03")
                .openProject("This project")
                .clickCreateCase()
                .fillNewCaseForm(caseForm = CaseFormFactory.fill());
        //validate case info
    }
}
