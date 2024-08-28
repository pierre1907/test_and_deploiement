Feature: UserController Api Tests
  Background:
    * url baseUrl = 'http://localhost:8080/users'
  Scenario: Get All Users
    Given url baseUrl
    When method GET
    Then status 200
    And match each response == { id: '#number', name: '#string', adresse: '#string', password: '#string' }

  Scenario: Create new User
    Given url baseUrl
    And request { id: null, name: 'Aissata', adresse : 'dakar', password: '234567890'}
    When method POST
    Then status 200
    And match response == { id: '#notnull', name: 'Aissata', adresse : 'dakar', password: '234567890'}
