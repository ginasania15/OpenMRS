package openMRS
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	@Given("User access Open MRS website")
	def accessOpenMRSwebsite() {
		WebUI.openBrowser("")
		WebUI.maximizeWindow()
		WebUI.navigateToUrl("https://demo.openmrs.org/openmrs/login.htm")
	}
	@When("User input username (.*) on Open MRS")
	def inputUsername(String username)	{
		WebUI.setText(findTestObject("Object Repository/login/usernameField"), username)
	}
	@And("User input password (.*) on Open MRS")
	def inputPassword(String password)	{
		WebUI.setText(findTestObject("Object Repository/login/passwordField"), password)
	}
	@And("User choose location (.*) for the session")
	def chooseLocation(String location) {
		if (location == "Inpatient Ward") {
			WebUI.click(findTestObject("Object Repository/login/location/locationInpatientWard"))
		}else if	(location == "Outpatient Clinic")	{
			WebUI.click(findTestObject("Object Repository/login/location/locationOutpatientClinic"))
		}else if	(location == "Isolation Ward")	{
			WebUI.click(findTestObject("Object Repository/login/location/locationIsolationWard"))
		}else if	(location == "Pharmacy")	{
			WebUI.click(findTestObject("Object Repository/login/location/locationPharmacy"))
		}else if	(location == "Laboratory")	{
			WebUI.click(findTestObject("Object Repository/login/location/locationLaboratory"))
		}else if (location == "Registration Desk") {
			WebUI.click(findTestObject("Object Repository/login/location/locationRegisrationDesk"))
		}
	}
	@And("User click Login button on Open MRS")
	def clickBtnLogin() {
		WebUI.click(findTestObject("Object Repository/login/btnLogin"))
	}
	//	Valid Case
	@Then("User successfully login as Super User at (.*)")
	def successLogin(String location)	{
		if	(location == "Inpatient Ward") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginInpatientWard"), "Logged in as Super User (admin) at Inpatient Ward.")
		}else if (location == "Outpatient Clinic") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginOutpatienClinic"), "Logged in as Super User (admin) at Outpatient Clinic.")
		}else if (location == "Isolation Ward") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginIsolationWard"), "Logged in as Super User (admin) at Isolation Ward.")
		}else if (location == "Pharmacy") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginPharmacy"), "Logged in as Super User (admin) at Pharmacy.")
		}else if (location == "laboratory") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginLaboratory"), "Logged in as Super User (admin) at Laboratory.")
		}else if (location == "Registration Desk") {
			WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginRegistrationDesk"), "Logged in as Super User (admin) at Registration Desk.")
		}
		WebUI.closeBrowser()
	}
	//	Invalid Case
	@Then("User will see error message on Login Page in Open MRS")
	def seeErrorMessage ()	{
		WebUI.verifyElementText(findTestObject("Object Repository/login/errorMessage"), "Invalid username/password. Please try again.")
		WebUI.closeBrowser()
	}
}