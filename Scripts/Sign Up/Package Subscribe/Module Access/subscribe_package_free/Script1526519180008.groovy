import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import randomWords.GenerateNumber as GenerateNumber

if (GlobalVariable.openBrowser == false) {
	WebUI.callTestCase(findTestCase('Sign Up/Package Subscribe/Module Access/package_home_URL'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementVisible(findTestObject('Package_Selection_OR/signup_free_link'), 10)

WebUI.click(findTestObject('Package_Selection_OR/signup_free_link'))

def randomWords = CustomKeywords.'randomWords.GenerateNumber.randomString'(4)

if(GlobalVariable.username.trim() != ''){
	GlobalVariable.username = (GlobalVariable.username + randomWords)
}

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/a.first_name_input'), GlobalVariable.username)

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/b.last_name_input'), 'Last Name')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/c.username_input'), GlobalVariable.username)

WebUI.setMaskedText(findTestObject('Signup_Form_User_Details_OR/d.password_input'), GlobalVariable.password)

WebUI.setMaskedText(findTestObject('Signup_Form_User_Details_OR/e.confirm_password_input'), GlobalVariable.password)

//def email = GlobalVariable.email
//if(GlobalVariable.email.trim() != ''){
	//String[] splitEmail = email.split('@')
	
	//GlobalVariable.email = splitEmail[0] + randomWords + '@' + splitEmail[1]
//}

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/f.email_input'), GlobalVariable.email)

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/g.contact_input'), '123456789')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/h.company_input'), 'Macrokiosk')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/i.position_input'), 'Software Tester')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/j.business_input'), 'Engagement Solution')

WebUI.click(findTestObject('Signup_Form_User_Details_OR/k.button_Register'))

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/package_name'), 60)

WebUI.verifyElementText(findTestObject('Account_Module_OR/package_name'), 'STARTER PlanUpgrade')

GlobalVariable.loggedin = true



