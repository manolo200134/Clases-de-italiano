Feature: Create a Token and then delete the Token
  Scenario: Create a Token and then delete the Token

    Given uso autentificacion basic
    When uso request GET al enlace /api/authentication/token.json con el json
    """

    """
    Then recivo una respuesta 200
    And recivo el TokenString guardado en TOKEN
    And verifico que el body de respuesta sea
    """
    {
    "TokenString": TOKEN,
    "UserEmail": "upb_api_prueba@upb.com",
    "ExpirationTime": "IGNORE"
}
    """
    When envio un delete rquest con TOKEN to /api/authentication/token.json
    Then recivo una respuesta 200
    And verifico que el body de respuesta sea
    """
    {
    "TokenString": TOKEN,
    "UserEmail": "upb_api_prueba@upb.com",
    "ExpirationTime": "IGNORE"
    }
    """