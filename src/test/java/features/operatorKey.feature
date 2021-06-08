Feature: Validating Operator key API
@Operator @all
  Scenario Outline: Verify if Operator key API is working with <scenerio>
    Given Operator key with "<csaKeyVersionNo>" "<exponent>" "<appVersionNumber>" "<idsBinVersionNo>" "<modulus>" "<merchantID>" "<osaKeyVersionNo>"   "<processingCode>" "<posSerialNumber>" "<reqId>" "<stan>""<terminalId>" "<idsKeyVersionNo>"
     When user calls Operator key "Operatorkey" with "POST" http request
     Then the Operator key API call got success with status code <status>
      And "status" in Operator key response body is "<body>" 
  
    Examples: 
      | scenerio | csaKeyVersionNo | exponent | appVersionNumber | idsBinVersionNo | modulus | merchantID      | osaKeyVersionNo | processingCode|posSerialNumber | reqId  | stan   | terminalId | idsKeyVersionNo | status | body | 
      | positive | 00              | 010001   | 0001             | 00              | default | 120000000000001 | 00              | 990000       |30383231363630353933  | 100002 | 100002 | 51000009   | 00              | 200    | OK   | 
  
