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
import com.kms.katalon.core.webui.keyword.builtin.CloseBrowserKeyword
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain

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



class register {
	@Given("User already logged in as Registration Desk")
	def userAlreadyLoggedin()	{
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.baseUrl)
		WebUI.setText(findTestObject("Object Repository/login/usernameField"), GlobalVariable.username)
		WebUI.setText(findTestObject("Object Repository/login/passwordField"), GlobalVariable.password)
		WebUI.click(findTestObject("Object Repository/login/location/locationRegisrationDesk"))
		WebUI.click(findTestObject("Object Repository/login/btnLogin"))
		WebUI.verifyElementText(findTestObject("Object Repository/login/txnSuccess/txtSuccessLoginRegistrationDesk"), "Logged in as Super User (admin) at Registration Desk.")
	}
	@When("User click Register a patient menu")
	def clickBtnRegister() {
		WebUI.click(findTestObject("Object Repository/dashboardMenu/btnRegisterPatient"))
	}
	@And("User input given name (.*)")
	def inputGivenName(String given) {
		WebUI.setText(findTestObject("Object Repository/registerForm/givenName"), given)
	}
	@And("User input middle name (.*)")
	def inputMiddleName(String middle)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/middleName"), middle)
	}
	@And("User input family name (.*)")
	def inputFamilyName(String family)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/familyName"), family)
	}
	@And("User click button next")
	def clickNextBtn ()	{
		WebUI.click(findTestObject("Object Repository/registerForm/btnNext"))
	}
	@And("User select gender (.*)")
	def selectGender (String gender) {
		WebUI.selectOptionByValue(findTestObject("Object Repository/registerForm/gender"), gender, false)
	}
	@And("User input birth date (.*), birth month (.*), birth year (.*)")
	def inputBirthDate(String bdate, String bmonth, String byear)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/bday"), bdate)
		WebUI.selectOptionByValue(findTestObject("Object Repository/registerForm/bmonth"), bmonth, false)
		WebUI.setText(findTestObject("Object Repository/registerForm/bYear"), byear)
	}
	@And("User input address field 1 (.*)")
	def inputAddressField1 (String address1) {
		WebUI.setText(findTestObject("Object Repository/registerForm/address1"), address1)
	}
	@And("User input address field 2 (.*)")
	def inputAddressField2 (String address2)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/address2"), address2)
	}
	@And("User input city field (.*)")
	def inputCity (String city)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/city"), city)
	}
	@And("User input state field (.*)")
	def inputStateField (String state)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/state"), state)
	}
	@And("User input country field (.*)")
	def inputCountryField (String country) {
		WebUI.setText(findTestObject("Object Repository/registerForm/country"), country)
	}
	@And("User input postal code field (.*)")
	def inputPostalCodeField (String postal)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/postalCode"), postal)
	}
	@And("User input phone number (.*)")
	def inputPhoneNumber (String phone)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/phone"), phone)
	}
	@And("User select relative (.*)")
	def selectRelative (String relative)	{
		WebUI.selectOptionByLabel(findTestObject("Object Repository/registerForm/relative"), relative, false)
	}
	@And("User input person name (.*)")
	def inputPersonName (String person)	{
		WebUI.setText(findTestObject("Object Repository/registerForm/person"), person)
	}
	@And("User click button confirm")
	def clickConfirmBtn () {
		WebUI.click(findTestObject("Object Repository/registerForm/btnConfirm"))
	}
	@Then("User registration should be successfull for given name (.*)")
	def successRegistration (String given)	{
		WebUI.verifyElementText(findTestObject("Object Repository/registerForm/txtSuccessRegist"), given)
		WebUI.closeBrowser()
	}
}