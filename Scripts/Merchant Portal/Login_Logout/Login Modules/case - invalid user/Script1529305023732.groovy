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

//verify invalid username or password
//verify account suspended
def verifyMsgServer = ''
def invalidUser = false
def userSuspended = false

if(WebUI.waitForElementPresent(findTestObject('Login_OR/msg_server'), buffertime)){
	verifyMsgServer = WebUI.getText(findTestObject('Login_OR/msg_server'))
	
	if(verifyMsgServer.equals(errorMsgInvalid) == true){
		invalidUser = true
	}else if (verifyMsgServer.equals(errorMsgSuspended) == true){
		userSuspended = true
	}else {
		throw new com.kms.katalon.core.exception.StepErrorException('Variable verifyMsgServer does not match to expected error msg!')
	}
	if(invalidUser == true || userSuspended == true){
		WebUI.delay(GlobalVariable.displaytime)
		WebUI.refresh()
	} else if (invalidUser == false && userSuspended == false) {
		throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong. Please check your coding!!')
	}
}

//verify login exceed limit 5 times
def verifyMsgExceedLimit = ''
def exceedLimit = false

if(WebUI.waitForElementPresent(findTestObject('Login_OR/msg_exceed_limit'), buffertime)){
	verifyMsgExceedLimit = WebUI.getText(findTestObject('Login_OR/msg_exceed_limit'))
	
	if(verifyMsgExceedLimit.compareTo(errorExceedLimit) == 0){
		exceedLimit = true
	}
	
	if(exceedLimit == true){
		WebUI.delay(GlobalVariable.displaytime)
		WebUI.refresh()
	} else if(exceedLimit == false){
		throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong. Please check your coding!!')
	}
	
}