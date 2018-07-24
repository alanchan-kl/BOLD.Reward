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

//verify username
if(WebUI.waitForElementPresent(findTestObject('Login_OR/msg_username'), buffertime)){
	verifyMsgUsername = WebUI.getText(findTestObject('Login_OR/msg_username'))
	if(verifyMsgUsername.equals(errorMsgUsername) == true){
		emptyUsername = true
	}else {
		throw new com.kms.katalon.core.exception.StepErrorException('Variable verifyMsgUsername does not match to expected error msg!')
	}
}

//verify password
if(WebUI.waitForElementPresent(findTestObject('Login_OR/msg_password'), buffertime)){
	verifyMsgPassword = WebUI.getText(findTestObject('Login_OR/msg_password'))
	if(verifyMsgPassword.equals(errorMsgPassword) == true){
		emptyPassword = true
	}else {
		throw new com.kms.katalon.core.exception.StepErrorException('Variable verifyMsgPassword does not match to expected error msg!')
	}
}

if(emptyUsername == true || emptyPassword == true){
	WebUI.delay(GlobalVariable.displaytime)
	WebUI.refresh()
}else if(emptyUsername == false || emptyPassword == false){
	throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong. Please check your coding!!')
}

