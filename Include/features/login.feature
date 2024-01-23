@Login
Feature: Login
  I want to login to Open MRS website

  Scenario Outline: Login using valid credential as Super User at <location>
    Given User access Open MRS website
    When User input username <username> on Open MRS
    And User input password <password> on Open MRS
    And User choose location <location> for the session
    And User click Login button on Open MRS
    Then User successfully login as Super User at <location>

    Examples: 
      | username | password | location					|
      | admin    | Admin123 | Inpatient Ward 		|
      | admin    | Admin123 | Outpatient Clinic |
      | admin    | Admin123 | Isolation Ward		|
      | admin    | Admin123 | Pharmacy					|
      | admin    | Admin123 | Laboratory		 		|
      | admin    | Admin123 | Registration Desk |
      
	Scenario Outline: Login using invalid credential at <location>
		Given User access Open MRS website
		When User input username <username> on Open MRS
		And User input password <password> on Open MRS
		And User choose location <location> for the session
		And User click Login button on Open MRS
		Then User will see error message on Login Page in Open MRS
	
		Examples:
			|	username	|	password	|	location					|
			|	admin			|	Admin1234	| Inpatient Ward		|
			|	admin			|						|	Inpatient Ward		|
			|						| Admin123	|	Inpatient Ward		|
			|	admin			|	Admin1234	| Outpatient Clinic	|
			|	admin			|						|	Outpatient Clinic	|
			|						| Admin123	|	Outpatient Clinic	|
			|	admin			|	Admin1234	| Isolation Ward		|
			|	admin			|						|	Isolation Ward		|
			|						| Admin123	|	Isolation Ward		|
			|	admin			|	Admin1234	| Pharmacy					|
			|	admin			|						|	Pharmacy					|
			|						| Admin123	|	Pharmacy					|
			|	admin			|	Admin1234	| Laboratory				|
			|	admin			|						|	Laboratory				|
			|						| Admin123	|	Laboratory				|
			|	admin			|	Admin1234	| Registration Desk	|
			|	admin			|						|	Registration Desk	|
			|						| Admin123	|	Registration Desk |