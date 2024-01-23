@register
Feature: Register Patient
  I want to register patient

  Scenario Outline: Register patient using valid data
    Given User already logged in as Registration Desk
    When User click Register a patient menu
    And User input given name <given>
    And User input middle name <middle>
    And User input family name <family>
    And User click button next
    And User select gender <gender>
    And User click button next
    And User input birth date <bdate>, birth month <bmonth>, birth year <byear>
    And User click button next
    And User input address field 1 <address1>
    And User input address field 2 <address2>
    And User input city field <city>
    And User input state field <state>
    And User input country field <country>
    And User input postal code field <postal>
    And User click button next
    And User input phone number <phone>
    And User click button next
    And User select relative <relative>
    And User input person name <person>
    And User click button next
    And User click button confirm
    Then User registration should be successfull for given name <given>
    
    Examples:
    	|	given	|	middle	|	family	|	gender	|	bdate	|	bmonth	|	byear	|	address1	|	address2	|	city			|	state			|	country		|	postal	|	phone					|	relative	|	person	|
    	| John	|	Doe			|	Doe			|	M				|	17		|	8				|	1999	|	Bandung		|	Bandung 2	|	Bandung 3	|	Jawa Barat|	Indonesia	|	40914		|	0123456789012	|	Doctor		|	Gina		|	