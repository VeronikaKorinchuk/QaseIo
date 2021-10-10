package pages;

import com.codeborne.selenide.Condition;
import models.CaseForm;
import models.CaseFormFactory;
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

    public ProjectDetailsPage fillNewCaseForm(CaseForm caseForm) {
        $(TITLE_LOCATOR).sendKeys(CaseFormFactory.fill().getTitle());
        new Dropdown("statusGroup", CaseFormFactory.fill().getStatus());
        new Dropdown("suiteGroup", CaseFormFactory.fill().getSuite());
        new Dropdown("severityGroup", CaseFormFactory.fill().getSeverity());
        new Dropdown("priorityGroup", CaseFormFactory.fill().getPriority());
        new Dropdown("typeGroup", CaseFormFactory.fill().getType());
        new Dropdown("layerGroup", CaseFormFactory.fill().getLayer());
        new Dropdown("is_flakyGroup", CaseFormFactory.fill().getIsFlaky());
        new Dropdown("milestoneGroup", CaseFormFactory.fill().getMilestone());
        new Dropdown("behaviorGroup", CaseFormFactory.fill().getBehavior());
        new Dropdown("automationStatusGroup", CaseFormFactory.fill().getAutomationStatus());
        return this;
    }
}
