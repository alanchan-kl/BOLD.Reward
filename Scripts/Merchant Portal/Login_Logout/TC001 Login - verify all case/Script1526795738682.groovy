import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.junit.After
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
import com.kms.katalon.core.exception.StepErrorException

WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/login'), [('username') : username, ('password') : password], 
    FailureHandling.STOP_ON_FAILURE)

switch (expected_result.toString()) {
	default:
		//verify login success
		if(WebUI.waitForElementPresent(findTestObject('Login_OR/topbar_username'), buffertime)){
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - login sucess'), [('username') : username], FailureHandling.STOP_ON_FAILURE)
			break
		}else if(username.trim() == '' || password == ''){
			//verify please complete username and password
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - empty username_password'), [:], FailureHandling.STOP_ON_FAILURE)
			break
		}else {
			//verify invalid user
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - invalid user'), [:], FailureHandling.STOP_ON_FAILURE)
			break
		}
		
		throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong. Please check your coding!!')
		break
		
		case 'Invalid user':
			//verify invalid user
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - invalid user'), [:], FailureHandling.STOP_ON_FAILURE)
			break
			
		case 'Please complete username and password field':
			//verify please complete username and password
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - empty username_password'), [:], FailureHandling.STOP_ON_FAILURE)
			break
			
		case 'Login Success':
		if(WebUI.waitForElementPresent(findTestObject('Login_OR/topbar_username'), buffertime)){
			WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/case - login sucess'), [('username') : username], FailureHandling.STOP_ON_FAILURE)
			break
		}else {
			throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong. Please check your coding!!')
			break
		}
}

