package adapters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Response;
import models.SharedStep;

public class SharedStepAdapter extends BaseAdapter{

    public void create(SharedStep sharedStep, String code) {
        post(new Gson().toJson(sharedStep), "v1/shared_step/" + code);
    }

    public void delete(String code, String hash) {
        del("v1/shared_step/" + code + "/" + hash);
    }

    public SharedStep get(String code, String hash) {
        String body = g("v1/shared_step/" + code + "/" + hash);
        return new Gson().fromJson(body, new TypeToken<Response<SharedStep>>() {}.getType());
    }
}
