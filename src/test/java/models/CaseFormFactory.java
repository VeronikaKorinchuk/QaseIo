package models;

public class CaseFormFactory {

    public static CaseForm fill() {
        return new CaseForm("Check that test case can be created", "Draft", "Test cases without suite",
                "Major","High", "Smoke", "API", "No", "Not set",
                "Not set", "Automated");
        }
    }
