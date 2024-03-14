package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.SimpleDateFormat
import java.util.Date
import org.testng.Assert

import internal.GlobalVariable

public class RegisterPage {
	def currentDate = new Date()
	def dateFormat = new SimpleDateFormat("ddMM_HH_mm_ss")
	def formattedDate = dateFormat.format(currentDate)

	String userEmail = "${GlobalVariable.Email}${formattedDate}@gmail.com"

	@Keyword
	def void UserRegister() {
		CommonCache.addToCache("userEmail", userEmail, 10)
		WebUI.setText(findTestObject('Nopcommerce/RegisterPage/FirstNameInputBox'), GlobalVariable.FirstName)
		WebUI.setText(findTestObject('Nopcommerce/RegisterPage/LastNameInputBox'), GlobalVariable.LastName)
		WebUI.setText(findTestObject('Nopcommerce/RegisterPage/EmailInputBox'), CommonCache.getFromCache("userEmail"))
		WebUI.setText(findTestObject('Nopcommerce/RegisterPage/PasswordInputBox'), GlobalVariable.Password)
		WebUI.setText(findTestObject('Nopcommerce/RegisterPage/ConfirmPasswordInputBox'), GlobalVariable.Password)

		WebUI.click(findTestObject('Nopcommerce/RegisterPage/RegisterButton'))
		Assert.assertEquals(WebUI.getText(HelperMethods.getTestObjectWithXpath("//div[@class='result']")), "Your registration completed")
		WebUI.click(findTestObject('Nopcommerce/RegisterPage/RegisterContinueButton'))
	}
}