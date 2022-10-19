package ar.validator;

import java.io.File;
import java.util.List;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

public class ProjectValidator {

    //TODO: validate the whole obtained response is equals to the expected response
    public static void validateList() throws Exception {
        ProjectResponse[] response = (ProjectResponse[]) APIManager.getLastResponse().getResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        List<ProjectResponse> validResponses = objectMapper.readValue(
                new File("src/test/resources/jsons/response/project/projectList.json"), new TypeReference<List<ProjectResponse>>() {
                });

        Assert.assertEquals(response.length, 1);
        Assert.assertEquals(response[0].getWorkspaceId(), validResponses.get(0).getWorkspaceId() );
        Assert.assertEquals(response[0].getName(), validResponses.get(0).getName() );
    }

    public static void validate() throws Exception {
        ProjectResponse response = (ProjectResponse) APIManager.getLastResponse().getResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        ProjectResponse validResponse = objectMapper.readValue(
                new File("src/test/resources/jsons/response/project/project.json"), ProjectResponse.class);

        Assert.assertEquals(response.getWorkspaceId(), validResponse.getWorkspaceId() );
        Assert.assertEquals(response.getName(), validResponse.getName());
    }

}