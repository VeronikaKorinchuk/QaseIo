package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class ProjectTest extends BaseTest{

    @Test
    public void projectShouldBeCreated() {
        new LoginPage()
                .open()
                .login(user, pass)
                .clickCreate()
                .fillNewProjectForm("This project", "", "Write smth", "Public",
                        "")
                .clickSave();
    }
}
