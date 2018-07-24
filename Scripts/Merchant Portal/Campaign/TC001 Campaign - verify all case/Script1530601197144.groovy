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
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import newtab.OpenTab as OpenTab
import randomWords.GenerateNumber as GenerateNumber


//Generate random words
def randomWords = CustomKeywords.'randomWords.GenerateNumber.randomString'(4)

if(companyName.trim() != ''){
	companyName = companyName + randomWords
}

if(campaignInstruc.trim() != ''){
	campaignInstruc = campaignInstruc + randomWords
}

if(emailSender.trim() != ''){
	def email = emailSender
	String[] splitEmail = email.split('@')
	def numb = splitEmail.length
	if(numb > 1){
		emailSender = splitEmail[0] + randomWords + '@' + splitEmail[1]
	}
}

if(emailSubject.trim() != ''){
	emailSubject = emailSubject + randomWords
}

if(emailContent.trim() != ''){
	emailContent = emailContent + randomWords
}

WebUI.callTestCase(findTestCase('Merchant Portal/Campaign/Campagin Modules/create campaign'), [('companyName') : companyName, ('campaignInstruc') : campaignInstruc, ('radioEmail') : radioEmail
        , ('radioMobileno') : radioMobileno, ('radioName') : radioName, ('radioGender') : radioGender, ('radioDOB') : radioDOB, ('campaignImage') : campaignImage
        , ('tcURL') : tcURL, ('emailSender') : emailSender, ('emailSubject') : emailSubject, ('emailContent') : emailContent, ('companyLogo') : companyLogo, ('rewardCode') : rewardCode], FailureHandling.STOP_ON_FAILURE)

def updateFailed = false
if(WebUI.waitForElementVisible(findTestObject('a.Not_Assigned_OR/alert_msg_top'), 3)){
	def verifyPopoutMsg = WebUI.getText(findTestObject('a.Not_Assigned_OR/alert_msg_top'))
	if(verifyPopoutMsg.equals(msgServer) == true){
		updateFailed = true
	}
}

def updateSuccess = false
if(WebUI.waitForElementVisible(findTestObject('Campaign_OR/Error Message/msg_edit_success'), 3)){
	def verifyUpdateMsg = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_edit_success'))
	
	if(verifyUpdateMsg.equals(msg_success_update) == true){
		updateSuccess = true
	}else {
		throw new com.kms.katalon.core.exception.StepErrorException('There are something went wrong.')
	}
}

def createSuccess = false
if(WebUI.waitForElementVisible(findTestObject('Home_OR/label_home'), 3)){
	createSuccess = true
}

if (updateSuccess == true) {
	//WebUI.delay(2)
	
    WebUI.callTestCase(findTestCase('Merchant Portal/Module Access/Home'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(2)

    //verify preview campaign
	WebUI.callTestCase(findTestCase('Merchant Portal/Campaign/Campagin Modules/verify campaign'), [('companyName') : companyName, ('campaignInstruc') : campaignInstruc
		, ('radioEmail') : radioEmail, ('radioMobileno') : radioMobileno, ('radioName') : radioName, ('radioGender') : radioGender, ('radioDOB') : radioDOB], FailureHandling.STOP_ON_FAILURE)
    
}else if (updateFailed == true){
	def verifyError = false
	//def verifyMandatoryField = true
	
	//verify empty company name
	if(companyName.trim() == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_company_name'))
		def verifyEmptyCompanyName = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_company_name'))
		WebUI.verifyMatch(verifyEmptyCompanyName, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty campaign instruction
	if(campaignInstruc.trim() == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_campaign_instruction'))
		def verifyEmptyCampaignInstruc = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_campaign_instruction'))
		WebUI.verifyMatch(verifyEmptyCampaignInstruc, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty radio checkbox for Email
	if(radioEmail.toLowerCase() == 'false'){
		WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/c.checkbox_email'), 2)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_radio_email'))
		def verifyEmptyRadioEmail = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_radio_email'))
		WebUI.verifyMatch(verifyEmptyRadioEmail, msgMandatoryEmail, true)
		verifyError = true
	}
	
	//verify empty campaign image
	def campaignImgName = WebUI.getText(findTestObject('Campaign_OR/uploadedCampaignImg'))
	
	if(campaignImgName == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_cpgn_image'))
		def verifyEmptyCampaignImg = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_cpgn_image'))
		WebUI.verifyMatch(verifyEmptyCampaignImg, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty sender
	if(emailSender.trim() == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_sender'))
		def verifyEmptySender = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_sender'))
		WebUI.verifyMatch(verifyEmptySender, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty subject
	if(emailSubject.trim() == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_subject'))
		def verifyEmptySubject = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_subject'))
		WebUI.verifyMatch(verifyEmptySubject, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty content
	if(emailContent.trim() == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_email_content'))
		def verifyEmptyContent = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_email_content'))
		WebUI.verifyMatch(verifyEmptyContent, msgMandatory, true)
		verifyError = true
	}
	
	//verify empty company logo
	def companyLogoName = WebUI.getText(findTestObject('Campaign_OR/uploadedCompanyLogo'))
	if(companyLogoName == ''){
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/Error Message/msg_company_logo2'))
		def verifyEmptyCampaignImg = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_company_logo2'))
		WebUI.verifyMatch(verifyEmptyCampaignImg, msgMandatory, true)
		verifyError = true
	}
	
	//verify image
	if (WebUI.waitForElementVisible(findTestObject('Campaign_OR/Error Message/msg_cpgn_image2'), 2)) {
		def verifyCampaignImgError = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_cpgn_image2'))
		
		if(verifyCampaignImgError.equals(msgInvalidSize)){
			verifyError = true
		}else if(verifyCampaignImgError.equals(msgInvalidDi)){
			verifyError = true
		}else if (verifyCampaignImgError.equals(msgFileFormat)){
			verifyError = true
		}else {
			WebUI.refresh()
			throw new com.kms.katalon.core.exception.StepErrorException('There are something went wrong.')
		}
	}
	
	//verify T&C URL
	if(WebUI.waitForElementVisible(findTestObject('Campaign_OR/Error Message/msg_TCURL'), 2)){
		def verifyURL = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_TCURL'))
		
		if(verifyURL.equals(msgTC) == true){
			verifyError = true
		}else {
			WebUI.refresh()
			throw new com.kms.katalon.core.exception.StepErrorException('There are something went wrong.')
		}
	}
	
	//verify sender
	if(emailSender.trim() != ''){
		if(WebUI.waitForElementVisible(findTestObject('Campaign_OR/Error Message/msg_sender'), 2)){
			def verifyEmail = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_sender'))
			
			if(verifyEmail.equals(msgInvalidEmail)){
				verifyError = true
			}else {
				WebUI.refresh()
				throw new com.kms.katalon.core.exception.StepErrorException('There are something went wrong.')
			}
		}
	}
	
	//verify company logo
	if (WebUI.waitForElementVisible(findTestObject('Campaign_OR/Error Message/msg_company_logo'), 2)) {
		def verifyCompanyLogo = WebUI.getText(findTestObject('Campaign_OR/Error Message/msg_company_logo'))
		
		if(verifyCompanyLogo.equals(msgInvalidSize)){
			verifyError = true
		}else if(verifyCompanyLogo.equals(msgInvalidDi)){
			verifyError = true
		}else if (verifyCompanyLogo.equals(msgFileFormat)){
			verifyError = true
		}else {
			WebUI.refresh()
			throw new com.kms.katalon.core.exception.StepErrorException('There are something went wrong.')
		}
	}
	WebUI.refresh()
	//verify missing verification
	if (verifyError == false){
		WebUI.refresh()
		throw new StepErrorException('There are some error which is not verify yet.')
	}
}else if (createSuccess == true){
	WebUI.delay(2)
	
	//verify preview campaign
	WebUI.callTestCase(findTestCase('Merchant Portal/Campaign/Campagin Modules/verify campaign'), [('companyName') : companyName, ('campaignInstruc') : campaignInstruc
		, ('radioEmail') : radioEmail, ('radioMobileno') : radioMobileno, ('radioName') : radioName, ('radioGender') : radioGender, ('radioDOB') : radioDOB], FailureHandling.STOP_ON_FAILURE)
}else {
	throw new StepErrorException('There are some error which is not verify yet.')
}




