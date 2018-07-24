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

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/button_upgrade_no_package'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/button_remove_card'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Account_Module_OR/button_upgrade_no_package'))

WebUI.waitForElementVisible(findTestObject('Package_Upgrade_OR/button_Subscribe'), 10)

WebUI.click(findTestObject('Package_Upgrade_OR/button_Subscribe'))

WebUI.waitForElementVisible(findTestObject('Package_Upgrade_Confirmation_OR/button_Yes'), 0)

WebUI.click(findTestObject('Package_Upgrade_Confirmation_OR/button_Yes'))

WebUI.waitForElementVisible(findTestObject('Payment_Summary_OR/d.button_Pay'), 0)

WebUI.click(findTestObject('Payment_Summary_OR/d.button_Pay'))

WebUI.waitForElementVisible(findTestObject('Payment_Summary_OR/f.msg_payment_success'), 50)

WebUI.verifyElementText(findTestObject('Payment_Summary_OR/f.msg_payment_success'), 'Recurring payment is successful.')

WebUI.delay(2)

WebUI.click(findTestObject('Payment_Summary_OR/e.button_Cancel'))

