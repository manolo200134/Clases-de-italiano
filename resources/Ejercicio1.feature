Feature: Create and update a user in Todo.ly
  Scenario: create and update the user

    Given I have access to Todo.ly
    When I send a POST petition to /api/user.json with json
    """
    {
    "Email":"examenmanuel3@upb.com",
    "FullName":"Manuel Alejandro",
    "Password":"prueba123"
    }
    """
    Then I recive a 200 response
    And I check that response has this body
    """
    {
    "Id": "IGNORE",
    "Email": "examenmanuel3@upb.com",
    "Password": null,
    "FullName": "Manuel Alejandro",
    "TimeZone": 0,
    "IsProUser": false,
    "DefaultProjectId": "IGNORE",
    "AddItemMoreExpanded": false,
    "EditDueDateMoreExpanded": false,
    "ListSortType": 0,
    "FirstDayOfWeek": 0,
    "NewTaskDueDate": -1,
    "TimeZoneId": "Pacific Standard Time"
}
    """

    When I send a PUT request to /api/user/0.json with user "examenmanuel3@upb.com" and password "prueba123" with json
    """
    {
      "FullName":"Manuel Alejandro Valenzuela Delgadillo"
    }
    """
    Then I check a 200 response
    And I check that response's Full name is "Manuel Alejandro Valenzuela Delgadillo"
