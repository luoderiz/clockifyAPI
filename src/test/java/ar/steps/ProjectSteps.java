package ar.steps;

import ar.validator.ProjectValidator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import services.BaseService;

public class ProjectSteps {

    @And("un workspace configurado")
    public void unWorkspaceConfigurado() {
        BaseService.ID_WORKSPACE.set("633f5b887bbee426a514c082");
    }

    @And("un workspace y proyecto configurado")
    public void unWorkspaceYProyectoValidosConfigurado() {
        BaseService.ID_WORKSPACE.set("633f5b887bbee426a514c082");
        BaseService.ID_PROJECT.set("633f5dac7bbee426a514d032");
    }

    @And("un workspace que existe y proyecto que no")
    public void unWorkspaceQueExisteYProyectoQueNo() {
        BaseService.ID_WORKSPACE.set("633f5b887bbee426a514c082");
        BaseService.ID_PROJECT.set("66613666");
    }

    @Then("se obtiene la lista de mis proyectos")
    public void validateProjectLists() throws Exception{
        ProjectValidator.validateList();
    }

    @Then("se obtiene el proyecto")
    public void validateProject() throws Exception{
        ProjectValidator.validate();
    }

}
