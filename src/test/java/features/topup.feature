Feature: Validating topUp  API
@TopUp @all
  Scenario Outline: Verify if topup API is working with <scenerio>
    Given topup with "<ChipData>" "<amount>" "<appVersionNumber>" "<batchNumber>" "<invoiceNumber>" "<merchantID>" "<merchantNameLoc>" "<nii>" "<posEntryMode>" "<posSerialNumber>" "<processingCode>" "<reqId>" "<stan>""<terminalId>" "<track2Data>""<fundingSource>"
     When user calls topup "topup" with "POST" http request
     Then the topup API call got success with status code <status>
      And "status" in topup response body is "<body>" 
  
    Examples: 
      | scenerio | ChipData | appVersionNumber | batchNumber | invoiceNumber | merchantID      | merchantNameLoc                          | nii | posEntryMode | posSerialNumber                        | processingCode | reqId  | stan   | terminalId | track2Data | fundingSource | amount  | body | status | case | RC | message | 
      | Positive | default  | 0021             | 000001      | 200032        | 120000000000001 | Pune Metro Test 1      KOREGAON PARKMHIN | 00  | 0051         | 30303030313730343931313031303033323237 | 280000         | 200032 | 200032 | 51000006   | default    | 02            | 100     | OK   | 200    | true | 00 |         | 
  
  
