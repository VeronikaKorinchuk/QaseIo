package tests;

import adapters.BaseAdapter;
import com.google.gson.Gson;
import models.Project;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest{

    @Test
    public void testCaseShouldBeCreated() {
        Project project = Project.builder().
        //        title("One else project").
        //        code("CODE").
                build();

        //projectAdapter.create(project);
        //Project actualProject = projectAdapter.get(project.getCode());
        //System.out.println(actualProject);
        //projectAdapter.delete(project.getCode());

        new BaseAdapter()
                .post(new Gson().toJson(project), "v1/project", 422);
    }
}
