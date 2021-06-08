Feature: Validating Logon API
@login @all
  Scenario Outline: Verify if Logon API is working with <scenerio>
    Given logon with "<appVersionNumber>" "<merchantID>" "<merchantNameLoc>" "<posSerialNumber>" "<processingCode>" "<reqId>" "<stan>" "<terminalId>"
     When user calls "Logon" with "POST" http request
     Then the API call got success with status code <status>
      And "status" in response body is "<body>" 
      And response message is "<message>" for "<case>"
      And response code is "<RC>" for "<case>"
  
    Examples: 
      | scenerio              | appVersionNumber | merchantID      | merchantNameLoc | posSerialNumber      | processingCode | reqId  | stan   | terminalId | status | RC | body        | message                             | case  | 
      | correct data          | 0001             | 120000000000001 | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 | 51000009   | 200    | 00 | OK          | 00053537000001                      | true  | 
      | null app version      |                  | 120000000000001 | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | APP VERSION NUMBER IS NULL OR EMPTY | false | 
      | null merchantID       | 0001             |                 | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | MERCHANT IS NULL OR EMPTY           | false | 
      | null merchantNameLoc  | 0001             | 120000000000001 |                 | 30383231363630353933 | 920000         | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | MERCHANT DETAILS IS NULL OR EMPTY   | false | 
      | null posSerialNumber  | 0001             | 120000000000001 | MMOPL           |                      | 920000         | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | POS SERIAL NUMBER IS NULL OR EMPTY  | false | 
      | null processingCode   | 0001             | 120000000000001 | MMOPL           | 30383231363630353933 |                | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | PROCESSING CODE IS NULL OR EMPTY    | false | 
      | null reqId            | 0001             | 120000000000001 | MMOPL           | 30383231363630353933 | 920000         |        | 100003 | 51000009   | 400    |    | BAD_REQUEST | REQUEST ID IS NULL OR EMPTY         | false | 
      | null terminalId       | 0001             | 120000000000001 | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 |            | 400    |    | BAD_REQUEST | TERMINAL ID IS NULL OR EMPTY        | false | 
      | null stan             | 0001             | 120000000000001 | MMOPL           | 30383231363630353933 | 920000         | 100003 |        | 51000009   | 400    |    | BAD_REQUEST | STAN IS NULL OR EMPTY               | false | 
      | Wrong MID             | 0001             | 1200000000001   | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 | 51000009   | 200    | 03 | OK          |                                     | true  | 
      | Wrong TID             | 0001             | 1200000000001   | MMOPL           | 30383231363630353933 | 920000         | 100003 | 100003 | 510009     | 200    | 03 | OK          |                                     | true  | 
      | Wrong processingCode  | 0001             | 1200000000001   | MMOPL           | 30383231363630353933 | 90000          | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | INCORRECT PROCESSING CODE           | false | 
      | Wrong posSerialNumber | 0001             | 1200000000001   | MMOPL           | 30383233630353933    | 920000         | 100003 | 100003 | 51000009   | 400    |    | BAD_REQUEST | INVALID POS SERIAL NUMBER           | false | 
  
