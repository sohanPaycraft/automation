Feature: Validating Parameter download API
@parameter @all
  Scenario Outline: Verify if Parameter download API is working with <Scenerio>
    Given ParamDownload with "<appVersionNumber>","<batchNumber>","<MerchantID>","<PosSerialNumber>","<ProcessingCode>","<ReqId>","<Stan>","<TerminalId>"
     When user calls param "Parameter" with "POST" http request
     Then the param API call got success with status code <Status>
      And "status" in param dowload response body is "<Body>" 
      And param download response  message is "<message>" for "<case>"
      And param download response code is "<RC>" for "<case>"
     
  
	    Examples: 
      | Scenerio              | appVersionNumber | MerchantID      | PosSerialNumber      | ProcessingCode | ReqId  | Stan   | TerminalId | batchNumber | Status | RC | Body        | message                             | case  | 
      | correct data          | 0001             | 120000000000001 | 30383231363630353933 | 930000         | 100004 | 100004 | 51000009   | 000001      | 200    | 00 | OK          |                                     | true  | 
      | null appVersionNumber |                  | 120000000000001 | 30383231363630353933 | 930000         | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | APP VERSION NUMBER IS NULL OR EMPTY | false | 
      | null MerchantID       | 0001             |                 | 30383231363630353933 | 930000         | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | MERCHANT IS NULL OR EMPTY           | false | 
      | null PosSerialNumber  | 0001             | 120000000000001 |                      | 930000         | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | POS SERIAL NUMBER IS NULL OR EMPTY  | false | 
      | null ProcessingCode   | 0001             | 120000000000001 | 30383231363630353933 |                | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | PROCESSING CODE IS NULL OR EMPTY    | false | 
      | null ReqId            | 0001             | 120000000000001 | 30383231363630353933 | 930000         |        | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | REQUEST ID IS NULL OR EMPTY         | false | 
      | null Stan             | 0001             | 120000000000001 | 30383231363630353933 | 930000         | 100004 |        | 51000009   | 000001      | 400    |    | BAD_REQUEST | STAN IS NULL OR EMPTY               | false | 
      | null TerminalId       | 0001             | 120000000000001 | 30383231363630353933 | 930000         | 100004 | 100004 |            | 000001      | 400    |    | BAD_REQUEST | TERMINAL ID IS NULL OR EMPTY        | false | 
      | null batchNumber      | 0001             | 120000000000001 | 30383231363630353933 | 930000         | 100004 | 100004 | 51000009   |             | 400    |    | BAD_REQUEST | BATCH NUMBER IS NULL OR EMPTY       | false | 
      | wrong mid             | 0001             | 12000000001     | 30383231363630353933 | 930000         | 100004 | 100004 | 51000009   | 000001      | 200    | 03 | OK          |                                     | true  | 
      | worng TerminalId      | 0001             | 120000000000001 | 30383231363630353933 | 930000         | 100004 | 100004 | 510009     | 000001      | 200    | 03 | OK          |                                     | true  | 
      | Wrong processingCode  | 0001             | 120000000000001 | 30383231363630353933 | 9000           | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | INCORRECT PROCESSING CODE           | false | 
      | Wrong posSerialNumber | 0001             | 120000000000001 | 30383231363353933    | 930000         | 100004 | 100004 | 51000009   | 000001      | 400    |    | BAD_REQUEST | INVALID POS SERIAL NUMBER           | false | 
  
  