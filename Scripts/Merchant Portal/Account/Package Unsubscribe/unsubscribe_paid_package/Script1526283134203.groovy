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

WebUI.waitForElementVisible(findTestObject('Account_Module_OR/upgrade_package_link'), 10)

WebUI.click(findTestObject('Account_Module_OR/upgrade_package_link'))

WebUI.waitForElementVisible(findTestObject('Package_Upgrade_OR/button_Unsubscribe'), 10)

WebUI.click(findTestObject('Package_Upgrade_OR/button_Unsubscribe'))

WebUI.waitForElementVisible(findTestObject('Package_Unsubscribe_OR/b.button_Yes'), 10)

WebUI.click(findTestObject('Package_Unsubscribe_OR/b.button_Yes'))

WebUI.waitForElementVisible(findTestObject('Package_Unsubscribe_OR/c.msg_package_stopped'), 20)

WebUI.verifyElementText(findTestObject('Package_Unsubscribe_OR/c.msg_package_stopped'), 'Package subscription is stopped and credit card info is removed.')

WebUI.delay(2)

WebUI.click(findTestObject('Package_Unsubscribe_OR/d.button_Return'))

WebUI.waitForElementVisible(findTestObject('Package_Upgrade_OR/button_Close'), 0)

WebUI.click(findTestObject('Package_Upgrade_OR/button_Close'))

