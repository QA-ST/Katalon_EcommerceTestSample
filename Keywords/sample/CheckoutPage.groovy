package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.testng.Assert

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CheckoutPage {

	@Keyword
	def void FillBillingAddressDetails(String Country, String City, String Address1, def PostalCode, def PhoneNumber) {
		WebUI.selectOptionByLabel(findTestObject('Nopcommerce/CheckoutPage/CountryDropdown'), Country, true)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/CityInputBox'), City)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/Address1_InputBox'), Address1)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/PostalCodeInputBox'), PostalCode)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/PhoneNumberInputBox'), PhoneNumber)
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/NewAddressContinueBtn'))
	}

	@Keyword
	def void ChooseBillingMethod() {
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/NextDayShippingRadioOption'))
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/ShippingMethodContinueBtn'))
	}

	@Keyword
	def void SelectPaymentMethod() {
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/CreditCardMethodRadioOption'))
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/PaymentMethodContinueBtn'))
	}

	@Keyword
	def void FillCardDetails(String CardHolderName, def CardNumber, def CardCode) {
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/CardHolderNameInuputBox'), CardHolderName)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/CardNumberInputBox'), CardNumber)
		WebUI.selectOptionByLabel(findTestObject('Nopcommerce/CheckoutPage/CardExpiryMonthDropdown'), "08", true)
		WebUI.selectOptionByLabel(findTestObject('Nopcommerce/CheckoutPage/CardExpiryYearDropdown'), "2030", true)
		WebUI.setText(findTestObject('Nopcommerce/CheckoutPage/CardCodeInputBox'), CardCode)
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/PaymentInfoContinueBtn'))
	}

	@Keyword
	def void completeOrder(String OderCompleteVerifyMsg) {
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/ConfirmOrderBtn'))
		Assert.assertEquals(WebUI.getText(HelperMethods.getTestObjectWithXpath("(//div[contains(@class,'order-completed')]//strong)[1]")), OderCompleteVerifyMsg)
		WebUI.click(findTestObject('Nopcommerce/CheckoutPage/OrderCompleteContinueButton'))
	}
}