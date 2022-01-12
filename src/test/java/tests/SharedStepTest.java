package tests;

import models.SharedStep;
import org.testng.annotations.Test;

public class SharedStepTest extends BaseTest{

    @Test
    public void sharedStepCanBeCreated() {
        SharedStep sharedStep = SharedStep.builder().
                title("Authorization").
                action("Login").
                build();
        sharedStepAdapter.create(sharedStep, "TP");
    }
}
