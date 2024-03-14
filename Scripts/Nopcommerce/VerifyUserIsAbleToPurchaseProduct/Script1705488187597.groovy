import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.NopcommerceUrl)
WebUI.waitForPageLoad(GlobalVariable.TimeoutAfter)
WebUI.maximizeWindow()

CustomKeywords.'sample.NavbarActions.ClickOnRegisterLink'()
CustomKeywords.'sample.RegisterPage.UserRegister'()
CustomKeywords.'sample.NavbarActions.ClickOnLoginLink'()
CustomKeywords.'sample.LoginPage.UserLogin'()
CustomKeywords.'sample.HomePage.ClickOnDesktopTopMenuOption_ComputerDropdown'()
CustomKeywords.'sample.DesktopPage.NavigateToDigitalStormDesktopProductPage'()
CustomKeywords.'sample.ProductPage.ClickAddToCartButton'()
CustomKeywords.'sample.ProductPage.CloseProductAddedNotificationBar'()
CustomKeywords.'sample.NavbarActions.ClickShoppingCartLink'()
CustomKeywords.'sample.CartPage.CompleteCheckoutProcess'()
CustomKeywords.'sample.CheckoutPage.FillBillingAddressDetails'("${Country}", "${City}", "${Address1}", "${PostalCode}", "${PhoneNumber}")
CustomKeywords.'sample.CheckoutPage.ChooseBillingMethod'()
CustomKeywords.'sample.CheckoutPage.SelectPaymentMethod'()
CustomKeywords.'sample.CheckoutPage.FillCardDetails'("${CardHolderName}", "${CardNumber}", "${CardCode}")
CustomKeywords.'sample.CheckoutPage.completeOrder'("${OrderCompleteVerifyMsg}")
CustomKeywords.'sample.NavbarActions.ClickOnLogoutLink'()
WebUI.closeBrowser()