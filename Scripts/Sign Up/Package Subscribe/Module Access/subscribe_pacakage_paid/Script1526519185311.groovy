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

WebUI.waitForElementVisible(findTestObject('Package_Selection_OR/signup_paid_link'), 10)

WebUI.click(findTestObject('Package_Selection_OR/signup_paid_link'))

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/a.first_name_input'), GlobalVariable.username)

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/b.last_name_input'), 'subscribe')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/c.username_input'), GlobalVariable.username)

WebUI.setMaskedText(findTestObject('Signup_Form_User_Details_OR/d.password_input'), GlobalVariable.password)

WebUI.setMaskedText(findTestObject('Signup_Form_User_Details_OR/e.confirm_password_input'), GlobalVariable.password)

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/f.email_input'), GlobalVariable.email)

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/g.contact_input'), '123456789')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/h.company_input'), 'Macrokiosk')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/i.position_input'), 'Software Tester')

WebUI.setText(findTestObject('Signup_Form_User_Details_OR/j.business_input'), 'Engagement Solution')

WebUI.setText(findTestObject('Payment_Details_OR/a.credit_card_number_input'), GlobalVariable.ccnumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Payment_Details_OR/b.expiry_month_dropdown'), 'string:10', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Payment_Details_OR/c.expiry_year_dropdown'), 'number:2020', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Payment_Details_OR/d.cvc_input'), '737')

WebUI.setText(findTestObject('Payment_Details_OR/e.card_holder_name_input'), 'Alan Chan')

WebUI.click(findTestObject('Signup_Form_User_Details_OR/k.button_Register'))

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/package_name'), 120)

WebUI.verifyElementText(findTestObject('Account_Module_OR/package_name'), 'BUSINESS PlanUpgrade')

GlobalVariable.loggedin = true