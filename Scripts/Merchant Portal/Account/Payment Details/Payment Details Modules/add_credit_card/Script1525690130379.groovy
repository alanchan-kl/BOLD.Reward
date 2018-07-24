import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable 
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.exception.StepErrorException

if (GlobalVariable.openBrowser == false) {
    WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/login'), [('username') : GlobalVariable.username, ('password') : GlobalVariable.password], 
        FailureHandling.STOP_ON_FAILURE)
	
}

if(GlobalVariable.accessModule == false){
	WebUI.callTestCase(findTestCase('Merchant Portal/Module Access/Account'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/button_add_card'), 5)

WebUI.click(findTestObject('Account_Module_OR/button_add_card'))

WebUI.waitForElementVisible(findTestObject('Payment_Details_OR/a.credit_card_number_input'), 5)

WebUI.setText(findTestObject('Payment_Details_OR/a.credit_card_number_input'), cardNumber , FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Payment_Details_OR/b.expiry_month_dropdown'), expiryMonth, true)

WebUI.selectOptionByValue(findTestObject('Payment_Details_OR/c.expiry_year_dropdown'), expiryYear, true)

WebUI.setText(findTestObject('Payment_Details_OR/d.cvc_input'), cvv)

WebUI.setText(findTestObject('Payment_Details_OR/e.card_holder_name_input'), cardholderName)

WebUI.click(findTestObject('Add_Credit_Card_OR/a.button_Save'))

WebUI.waitForElementVisible(findTestObject('Add_Credit_Card_OR/b.msg_authorize_payment_details'), 20)

//WebUI.verifyElementText(findTestObject('Add_Credit_Card_OR/b.msg_authorize_payment_details'), auth_success)

WebUI.delay(2)

WebUI.click(findTestObject('Add_Credit_Card_OR/c.button_Cancel'))

WebUI.delay(1)

