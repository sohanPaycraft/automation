Feature: Validating Operator key API
@keyinjection @all
  Scenario Outline: Verify if keyinjection API is working with <scenerio>
    Given keyinjection with  "<exponent>" "<appVersionNumber>"  "<modulus>"   "<processingCode>" "<posSerialNumber>" "<reqId>" "<stan>""
     When user calls keyinjection "keyinjection" with "POST" http request
     Then the keyinjection API call got success with status code <status>
      And "status" in keyinjection response body is "<body>" 
  
    Examples: 
      | scenerio | exponent | appVersionNumber | modulus | processingCode | posSerialNumber      | reqId  | stan   | status | body | 
      | positive | 010001   | 0001             | default | 970000         | 30383231363630353933 | 100002 | 100002 | 200    | OK   | 
