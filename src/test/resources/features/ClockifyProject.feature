@Smoke
Feature: Project
  COMO usuario de Clockify
  QUIERO consultar mis proyectos
  PARA llevar un buen control del estado de mis proyectos

  @Project @GetAll @Success
  Scenario Outline: Consulta de todos mis proyectos en un workspace dado
    Given Mi cuenta creada en clockify y mi X-Api-Key generada
    And un workspace configurado
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    And  se obtiene la lista de mis proyectos
    Examples:
      | operation | entity    | jsonName                            | status |
      | GET       | PROJECTS   | project/queryAllProjectsOnWorkspace| 200    |

  @Project @GetOne @Success
  Scenario Outline: Consulta de un proyecto existente en workspace existente
    Given Mi cuenta creada en clockify y mi X-Api-Key generada
    And un workspace y proyecto configurado
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    Then se obtiene el proyecto
    Examples:
      | operation | entity    | jsonName                                   |  status |
      | GET       | PROJECT   | project/queryProjectByProjectIdOnWorkspace |  200    |

  @Project @GetOne @Fail
  Scenario Outline: Consulta de un proyecto que no existe en workspace existente
    Given Mi cuenta creada en clockify y mi X-Api-Key generada
    And un workspace que existe y proyecto que no
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then se obtuvo el status code <status>
    Examples:
      | operation | entity    | jsonName                                   |  status |
      | GET       | PROJECT   | project/queryProjectByProjectIdOnWorkspace |  404    |

  @Project @GetOne @Fail
  Scenario Outline: Consulta de un proyecto en workspace existente con key id invalida
    Given X-Api-Key invalido
    And un workspace y proyecto configurado
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    And se obtuvo el status code <status>
    Examples:
      | operation | entity    | jsonName                                   | status |
      | GET       | PROJECT   | project/queryProjectByProjectIdOnWorkspace | 401    |