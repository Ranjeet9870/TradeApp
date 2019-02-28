Feature: Checking app which will read the two trade files

@Run
Scenario Outline: Instrument wise traded volume between the date range
  Given "<instid>" instrument traded date between "<fromDate>" and "<toDate>"
  Then verify the "<instid>" traded volume between "<fromDate>" and "<toDate>"

  Examples: 
    | fromDate            | toDate              | instid |
    | 27/11/2017 23:11:01 | 02/12/2017 23:11:01 | IN1    |

@Run
Scenario Outline: List of instrument not traded between the dates
  Given all instrument not traded between "<fromDate>" and "<toDate>"
  Then "<instid>" should be present in the list of untraded instrument between "<fromDate>" and "<toDate>"

  Examples: 
    | fromDate            | toDate              | instid |
    | 01/12/2017 23:11:01 | 30/12/2017 23:11:01 | IN2    |
