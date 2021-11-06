package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Response;
import models.Suite;

public class SuiteAdapter extends BaseAdapter{

    public void create(Suite suite) {
        post(new Gson().toJson(suite), "v1/suite");
    }

    public void delete(String code) {
        del("v1/suite/" + code);
    }

    public Suite get(String code, String suiteId) {
        String body = g("v1/suite/" + code + "/" + suiteId);
        return new Gson().fromJson(body, new TypeToken<Response<Suite>>() {}.getType());
    }
}
