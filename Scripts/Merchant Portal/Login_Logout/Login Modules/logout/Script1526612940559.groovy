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

if (GlobalVariable.loggedin == false) {
    WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/access_merchant_login_URL'), [:], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/TC001 Login - verify all case'), [('username') : GlobalVariable.username
		, ('password') : GlobalVariable.password, ('expected_result') : '', ('buffertime') : 5], FailureHandling.STOP_ON_FAILURE)
}

if (GlobalVariable.checkPointer == false) {
    WebUI.waitForElementPresent(findTestObject('Login_OR/topbar_username'), 5)

    WebUI.waitForElementVisible(findTestObject('Login_OR/topbar_username'), 5)
}

if(GlobalVariable.loggedout == false){
	WebUI.waitForElementNotVisible(findTestObject('a.Not_Assigned_OR/alert_msg_top'), 5)
	
	WebUI.click(findTestObject('Logout_OR/a.username_link'))
	
	WebUI.click(findTestObject('Logout_OR/b.logout_selection'))
	
	WebUI.waitForElementVisible(findTestObject('Logout_OR/c.yes_button'), 10)
	
	WebUI.click(findTestObject('Logout_OR/c.yes_button'))
	
	GlobalVariable.loggedout = true
}



