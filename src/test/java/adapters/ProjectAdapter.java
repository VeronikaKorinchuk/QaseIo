package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Project;
import models.Response;

public class ProjectAdapter extends BaseAdapter{

    public void create(Project project) {
        post(new Gson().toJson(project), "v1/project");
    }

    public void delete(String code) {
        del("v1/project/" + code);
    }

    public Project get(String code) {
        String body = g("v1/project/" + code);
        return new Gson().fromJson(body, new TypeToken<Response<Project>>() {}.getType());
    }
}
