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
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import internal.GlobalVariable as GlobalVariable

WebUI.verifyElementNotVisible(findTestObject('Home_OR/msg_campaign_banner'), FailureHandling.OPTIONAL)
WebUI.waitForElementVisible(findTestObject('Home_OR/preview_img'), 5)
WebUI.verifyElementVisible(findTestObject('Home_OR/preview_img'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Home_OR/preview_company_name'), FailureHandling.STOP_ON_FAILURE)

def verifyPreviewCompanyName = WebUI.getText(findTestObject('Home_OR/preview_company_name'))

WebUI.verifyMatch(verifyPreviewCompanyName, companyName, true)

WebUI.verifyElementVisible(findTestObject('Home_OR/preview_campaign_instruction'), FailureHandling.STOP_ON_FAILURE)

def verifyPreviewCampaignInstruc = WebUI.getText(findTestObject('Home_OR/preview_campaign_instruction'))

WebUI.verifyMatch(verifyPreviewCampaignInstruc, campaignInstruc, false)

def verifyEmail = false

if (radioEmail.toLowerCase() == 'true') {
	verifyEmail = true
} else if (radioEmail.toLowerCase() == 'false') {
	verifyEmail = false
} else {
	throw new StepErrorException('Please insert valid value in radioEmail.')
}

if (verifyEmail == true) {
	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_label_email'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_email'), FailureHandling.STOP_ON_FAILURE)
} else if (verifyEmail == false) {
	throw new StepErrorException('Something wents wrong!!!')
}

def verifyMobileno = false

if (radioMobileno.toLowerCase() == 'true') {
	verifyMobileno = true
} else if (radioMobileno.toLowerCase() == 'false') {
	verifyMobileno = false
} else {
	throw new StepErrorException('Please insert valid value in radioMobileno.')
}

if (verifyMobileno == true) {
	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_countrycode'), FailureHandling.STOP_ON_FAILURE)

	WebUI.getText(findTestObject('Home_OR/preview_countrycode'))

	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_mobileno'), FailureHandling.STOP_ON_FAILURE) //WebUI.getText(findTestObject('Home_OR/preview_mobileno'))
} else if (verifyMobileno == false) {
	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_countrycode'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_mobileno'), FailureHandling.STOP_ON_FAILURE)
}

def verifyName = false

if (radioName.toLowerCase() == 'true') {
	verifyName = true
} else if (radioName.toLowerCase() == 'false') {
	verifyName = false
} else {
	throw new StepErrorException('Please insert valid value in radioName.')
}

if (verifyName == true) {
	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_label_name'), FailureHandling.STOP_ON_FAILURE)

	WebUI.getText(findTestObject('Home_OR/preview_label_name'))

	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_name'), FailureHandling.STOP_ON_FAILURE) //WebUI.getText(findTestObject('Home_OR/preview_name'))
} else if (verifyName == false) {
	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_label_name'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_name'), FailureHandling.STOP_ON_FAILURE)
}

def verifyGender = false

if (radioGender.toLowerCase() == 'true') {
	verifyGender = true
} else if (radioGender.toLowerCase() == 'false') {
	verifyGender = false
} else {
	throw new StepErrorException('Please insert valid value in radioGender.')
}

if (verifyGender == true) {
	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_gender_male'), FailureHandling.STOP_ON_FAILURE)

	WebUI.getText(findTestObject('Home_OR/preview_gender_male'))

	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_gender_female'), FailureHandling.STOP_ON_FAILURE)

	WebUI.getText(findTestObject('Home_OR/preview_gender_female'))
} else if (verifyGender == false) {
	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_gender_male'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_gender_female'), FailureHandling.STOP_ON_FAILURE)
}

def verifyDOB = false

if (radioDOB.toLowerCase() == 'true') {
	verifyDOB = true
} else if (radioDOB.toLowerCase() == 'false') {
	verifyDOB = false
} else {
	throw new StepErrorException('Please insert valid value in radioDOB.')
}

if (verifyDOB == true) {
	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_label_dob'), FailureHandling.STOP_ON_FAILURE)

	WebUI.getText(findTestObject('Home_OR/preview_label_dob'))

	WebUI.verifyElementVisible(findTestObject('Home_OR/preview_dob'), FailureHandling.STOP_ON_FAILURE)
} else if (verifyDOB == false) {
	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_label_dob'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_dob'), FailureHandling.STOP_ON_FAILURE)
}

def currentWindow = WebUI.getWindowIndex()

//Go in to new tab
//CustomKeywords.'newtab.OpenTab.opentab'()
int nextTabIndex = currentWindow + 1

if(GlobalVariable.viewport_width <= 1007){
	def viewport_height = WebUI.getViewportHeight()
	WebUI.setViewPortSize(700, viewport_height)
}

WebUI.click(findTestObject('Home_OR/button_URL'))

WebUI.waitForElementVisible(findTestObject('Home_OR/campaign_url'), 5)

WebUI.waitForElementVisible(findTestObject('Home_OR/button_Preview URL'), 5)

//newURL = WebUI.getText(findTestObject('Home_OR/button_Preview URL'))
WebUI.click(findTestObject('Home_OR/button_Preview URL'))

//WebUI.navigateToUrl(newURL)
WebUI.switchToWindowIndex(nextTabIndex)

//verify campaign
WebUI.waitForElementVisible(findTestObject('Campaign_Subscribe/campaign_img'), 5)

WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/campaign_img'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/company_name'), FailureHandling.STOP_ON_FAILURE)

def verifyCompanyName = WebUI.getText(findTestObject('Campaign_Subscribe/company_name'))

WebUI.verifyMatch(verifyCompanyName, companyName, true)

WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/campaign_instruction'), FailureHandling.STOP_ON_FAILURE)

def verifyCampaignInstruction = WebUI.getText(findTestObject('Campaign_Subscribe/campaign_instruction'))

WebUI.verifyMatch(verifyCampaignInstruction, campaignInstruc, true)

if (verifyEmail == true) {
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/input_email'), FailureHandling.STOP_ON_FAILURE) //WebUI.verifyElementVisible(findTestObject('Home_OR/preview_email'), FailureHandling.STOP_ON_FAILURE)
} else if (verifyEmail == false) {
	throw new StepErrorException('Something wents wrong!!!')
}

if (verifyMobileno == true) {
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/country_code'), FailureHandling.STOP_ON_FAILURE)

	//WebUI.getText(findTestObject('Home_OR/preview_countrycode'))
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/input_mobileno'), FailureHandling.STOP_ON_FAILURE) //WebUI.getText(findTestObject('Home_OR/preview_mobileno'))
} else if (verifyMobileno == false) {
	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/country_code'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/input_mobileno'), FailureHandling.STOP_ON_FAILURE)
}

if (verifyName == true) {
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/input_name'), FailureHandling.STOP_ON_FAILURE) //WebUI.getText(findTestObject('Home_OR/preview_label_name'))
	//WebUI.verifyElementVisible(findTestObject('Home_OR/preview_name'), FailureHandling.STOP_ON_FAILURE)
	//WebUI.getText(findTestObject('Home_OR/preview_name'))
	//WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_name'), FailureHandling.STOP_ON_FAILURE)
} else if (verifyName == false) {
	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/input_name'), FailureHandling.STOP_ON_FAILURE)
}

if (verifyGender == true) {
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/radio_male'), FailureHandling.STOP_ON_FAILURE)

	//WebUI.getText(findTestObject('Campaign_Subscribe/radio_male'))

	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/radio_female'), FailureHandling.STOP_ON_FAILURE)

	//WebUI.getText(findTestObject('Campaign_Subscribe/radio_female'))
} else if (verifyGender == false) {
	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/radio_male'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/radio_female'), FailureHandling.STOP_ON_FAILURE)
}

if (verifyDOB == true) {
	WebUI.verifyElementVisible(findTestObject('Campaign_Subscribe/input_dob'), FailureHandling.STOP_ON_FAILURE) //WebUI.getText(findTestObject('Home_OR/preview_label_dob'))
	//WebUI.verifyElementVisible(findTestObject('Home_OR/preview_dob'), FailureHandling.STOP_ON_FAILURE)
	//WebUI.verifyElementNotVisible(findTestObject('Home_OR/preview_dob'), FailureHandling.STOP_ON_FAILURE)
} else if (verifyDOB == false) {
	WebUI.verifyElementNotVisible(findTestObject('Campaign_Subscribe/input_dob'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.closeWindowIndex(nextTabIndex)
WebUI.switchToWindowIndex(currentWindow)

WebUI.scrollToElement(findTestObject('Home_OR/button_Close'), 2)
WebUI.click(findTestObject('Home_OR/button_Close'))
GlobalVariable.accessModule = false