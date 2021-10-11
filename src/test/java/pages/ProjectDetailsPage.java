package pages;

import com.codeborne.selenide.Condition;
import models.TestCaseFactory;
import org.openqa.selenium.By;
import wrappers.Dropdown;
import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    public static final String CREATE_NEW_CASE_LOCATOR = "//a[contains(@class, 'ms-3')][contains(text(), " +
            "'Create new case')]";
    public static final String TITLE_LOCATOR = "#title";

    public ProjectDetailsPage clickCreateCase() {
        $(By.xpath(CREATE_NEW_CASE_LOCATOR)).click();
        $(By.xpath(CREATE_NEW_CASE_LOCATOR)).shouldBe(Condition.disappear);
        return this;
    }

    public ProjectDetailsPage fillNewCaseForm() {
        $(TITLE_LOCATOR).sendKeys(TestCaseFactory.get().getTitle());
        new Dropdown("statusGroup", TestCaseFactory.get().getStatus());
        new Dropdown("suiteGroup", TestCaseFactory.get().getSuite());
        new Dropdown("severityGroup", TestCaseFactory.get().getSeverity());
        new Dropdown("priorityGroup", TestCaseFactory.get().getPriority());
        new Dropdown("typeGroup", TestCaseFactory.get().getType());
        new Dropdown("layerGroup", TestCaseFactory.get().getLayer());
        new Dropdown("is_flakyGroup", TestCaseFactory.get().getIsFlaky());
        new Dropdown("milestoneGroup", TestCaseFactory.get().getMilestone());
        new Dropdown("behaviorGroup", TestCaseFactory.get().getBehavior());
        new Dropdown("automationStatusGroup", TestCaseFactory.get().getAutomationStatus());
        return this;
    }
}
