package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public static final String CREATE_PROJECT_BUTTON = "#createButton";
    public static final String TITLE_LOCATOR = "#inputTitle";
    public static final String CODE_LOCATOR = "#inputCode";
    public static final String DESCRIPTION_LOCATOR = "#inputDescription";
    public static final String PROJECT_TITLES = "a.defect-title";

    public ProjectsPage isOpened() {
        $(CREATE_PROJECT_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage clickCreate() {
        $(CREATE_PROJECT_BUTTON).click();
        $(TITLE_LOCATOR).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage fillNewProjectForm(String projectName, String codeName, String description, String accessType,
                                           String memberAccess) {
        $(TITLE_LOCATOR).sendKeys(projectName);
        if(StringUtils.isEmpty(codeName)) {
            $(CODE_LOCATOR).sendKeys(codeName);
        }
        $(DESCRIPTION_LOCATOR).sendKeys(description);
        switch (accessType) {
            case "Public": {
                $("#public-access-type").click();
                break;
            }
            case "Private": {
                $("#private-access-type").click();
                switch (memberAccess) {
                    case "Add all members to this project": {
                        $("#accessAll").click();
                    }
                    case "Add members from specific group": {
                        $("#accessGroup").click();
                    }
                    case "Don't add members": {
                        $("#accessNone").click();
                    }
                }
                break;
            }
        }
        return this;
    }

    public ProjectsPage clickSave() {
        $(DESCRIPTION_LOCATOR).submit();
        $(DESCRIPTION_LOCATOR).shouldBe(Condition.disappear);
        return this;
    }

    public ProjectDetailsPage openProject(String name) {
        $$(PROJECT_TITLES).findBy(Condition.text(name)).click();
        $(By.xpath("//div(contains(@id, 'react-select'))"));
        return new ProjectDetailsPage();
    }
}
