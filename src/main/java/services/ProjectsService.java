package services;

import java.util.HashMap;
import java.util.Map;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

public class ProjectsService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, ProjectResponse[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("base.url", PropertyManager.getProperty("base.api.url"));
        params.put("api-key", API_KEY.get());
        params.put("workspaceId", ID_WORKSPACE.get());

        return params;
    }

}