import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.deleteClause_scope as deleteClause_scope
import org.junit.After as After
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
import uploadFile.UploadImage as UploadImage
import uploadFile.CancelUpload as CancelUpload
import os.DetectOS as DetectOS

//detect OS
def osName = ''
osName = CustomKeywords.'os.DetectOS.getOperatingSystem'(osName)
String[] splitString = osName.split()
GlobalVariable.os = splitString[0].toString()

//WS.verifyMatch(splitString[0], 'Windows', false)

if(GlobalVariable.loggedin == false){
	WebUI.callTestCase(findTestCase('Merchant Portal/Login_Logout/Login Modules/login'), [:],
		FailureHandling.STOP_ON_FAILURE)
}

if (GlobalVariable.accessModule == false) {
    WebUI.callTestCase(findTestCase('Merchant Portal/Module Access/Campaign'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.delay(5)

WebUI.setText(findTestObject('Campaign_OR/Fields/a.input_company_name'), companyName)

WebUI.setText(findTestObject('Campaign_OR/Fields/b.textarea_campaign_instruction'), campaignInstruc)

def verifyEmail = false

if(radioEmail.toLowerCase() == 'true'){
	verifyEmail = true
}

if (verifyEmail == true) {
    //WebUI.waitForElementNotVisible(findTestObject('Campaign_OR/input_email'), 1)
    //WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/c.checkbox_email'), 1, FailureHandling.OPTIONAL)
    if (WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/c.checkbox_email'), 1, FailureHandling.OPTIONAL)) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/c.checkbox_email'))
		
        WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_email'), FailureHandling.STOP_ON_FAILURE)
    }else{
		//WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_email'), FailureHandling.STOP_ON_FAILURE)
	}
}else if(verifyEmail == false){
	if(WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/c.checkbox_email'), 1, FailureHandling.OPTIONAL)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/c.checkbox_email'))
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_email'), FailureHandling.STOP_ON_FAILURE)
	}else {
		//WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_email'), FailureHandling.STOP_ON_FAILURE)
	}
}

def verifyMobileno = false
if(radioMobileno.toLowerCase() == 'true'){
	verifyMobileno = true
}

if (verifyMobileno == true) {
    if (WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/d.checkbox_mobile_number'), 1, FailureHandling.OPTIONAL)) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/d.checkbox_mobile_number'))

        WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_mobileno'), FailureHandling.STOP_ON_FAILURE)
    }else {
		//WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_mobileno'), FailureHandling.STOP_ON_FAILURE)
	}
}else if (verifyMobileno == false){
	if(WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/d.checkbox_mobile_number'), 1, FailureHandling.OPTIONAL)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/d.checkbox_mobile_number'))
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_mobileno'), FailureHandling.STOP_ON_FAILURE)
	}else {
		//WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_mobileno'), FailureHandling.STOP_ON_FAILURE)
	}
}

def verifyName = false
if(radioName.toLowerCase() == 'true'){
	verifyName = true
}

if (verifyName == true) {
    if (WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/e.checkbox_name'), 1, FailureHandling.OPTIONAL)) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/e.checkbox_name'))

        WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_name'), FailureHandling.STOP_ON_FAILURE)
    }else {
		//WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_name'), FailureHandling.STOP_ON_FAILURE)
	}
}else if (verifyName == false){
	if(WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/e.checkbox_name'), 1, FailureHandling.OPTIONAL)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/e.checkbox_name'))
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_name'), FailureHandling.STOP_ON_FAILURE)
	}else {
		//WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_name'), FailureHandling.STOP_ON_FAILURE)
	}
}

def verifyGender = false
if(radioGender.toLowerCase() == 'true'){
	verifyGender = true
}

if (verifyGender == true) {
    if (WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/f.checkbox_gender'), 1, FailureHandling.OPTIONAL)) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/f.checkbox_gender'))

        WebUI.verifyElementVisible(findTestObject('Campaign_OR/label_Male'), FailureHandling.STOP_ON_FAILURE)

        WebUI.verifyElementVisible(findTestObject('Campaign_OR/label_Female'), FailureHandling.STOP_ON_FAILURE)
    }else {
		//WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/label_Male'), FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Campaign_OR/label_Female'), FailureHandling.STOP_ON_FAILURE)
	}
}else if (verifyGender == false){
	if(WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/f.checkbox_gender'), 1, FailureHandling.OPTIONAL)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/f.checkbox_gender'))
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/label_Male'), FailureHandling.STOP_ON_FAILURE)
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/label_Female'), FailureHandling.STOP_ON_FAILURE)
	}else {
		//WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/label_Male'), FailureHandling.STOP_ON_FAILURE)
	
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/label_Female'), FailureHandling.STOP_ON_FAILURE)
	}
}

def verifyDOB = false
if(radioDOB.toLowerCase() == 'true'){
	verifyDOB = true
}

if (verifyDOB == true) {
    if (WebUI.verifyElementNotChecked(findTestObject('Campaign_OR/Fields/g.checkbox_dob'), 1, FailureHandling.OPTIONAL)) {
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/g.checkbox_dob'))
		
        WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_datepicker'), FailureHandling.STOP_ON_FAILURE)
    }else {
		//WebUI.delay(1)
		WebUI.verifyElementVisible(findTestObject('Campaign_OR/input_datepicker'), FailureHandling.STOP_ON_FAILURE)
	}
}else if (verifyDOB == false){
	if(WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/g.checkbox_dob'), 1, FailureHandling.OPTIONAL)){
		WebUI.delay(1)
		WebUI.click(findTestObject('Campaign_OR/Fields/g.checkbox_dob'))
		
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_datepicker'), FailureHandling.STOP_ON_FAILURE)
	}else {
		//WebUI.delay(1)
		WebUI.verifyElementNotVisible(findTestObject('Campaign_OR/input_datepicker'), FailureHandling.STOP_ON_FAILURE)
	}
}

//CustomKeywords.'uploadFile.UploadImage.chooseImg'(findTestObject('Campaign_OR/Fields/h.button_campaign_image'), campaignImagePath + campaignImage)
def filepath = ''
//imgName = ''
if(GlobalVariable.os == 'Windows'){
	filepath = GlobalVariable.campaignImagePath
	//imgName = campaignImage
}else if (GlobalVariable.os == 'Mac'){
	filepath = GlobalVariable.mcampaignImagePath
	//imgName = mcampaignImage
}

def verifyImgName = ''
def uploadedImg = false
//int reuploadCount = 0
//int maxReupload = 2

if(filepath.trim() != '' && campaignImage.trim() != ''){
	//CustomKeywords.'uploadFile.UploadImage.chooseImg'(GlobalVariable.os, findTestObject('Campaign_OR/Fields/h.button_campaign_image'), filepath + campaignImage)
	WebUI.sendKeys(findTestObject('Campaign_OR/Fields/h.button_campaign_image_1'), filepath + campaignImage)
	
	//WebUI.uploadFile(findTestObject('Campaign_OR/Fields/h.button_campaign_image'), 'C:\\Users\\kl.chan\\Katalon Studio\\boldreward\\Images\\Campaign Image\\Starbucks_banner.png')
	WebUI.delay(1)
	
	if(WebUI.waitForElementVisible(findTestObject('Campaign_OR/uploadedCampaignImg'), 30)){
		verifyImgName = WebUI.getText(findTestObject('Campaign_OR/uploadedCampaignImg'))
		
		if (verifyImgName.equals(campaignImage) == true) {
			uploadedImg = true
		} else if (uploadedImg == false) {
			throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong with the upload file.')
			//if(reuploadCount < maxReupload){
			//	CustomKeywords.'uploadFile.CancelUpload.pressDelete'()
			//	CustomKeywords.'uploadFile.UploadImage.chooseImg'(GlobalVariable.os, findTestObject('Campaign_OR/Fields/h.button_campaign_image'), filepath + campaignImage)
			//	reuploadCount++
			//}else {
			//	throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong with the upload file.')
			//}
		}
	}
}

WebUI.setText(findTestObject('Campaign_OR/Fields/i.k.input_tnc'), tcURL)

WebUI.setText(findTestObject('Campaign_OR/Fields/j.input_sender'), emailSender)

WebUI.setText(findTestObject('Campaign_OR/Fields/k.input_subject'), emailSubject)

WebUI.setText(findTestObject('Campaign_OR/Fields/l.textarea_content'), emailContent)

//CustomKeywords.'uploadFile.UploadImage.chooseImg'(findTestObject('Campaign_OR/Fields/m.button_company_logo'), companyLogoPath + companyLogo)
//CustomKeywords.'uploadFile.MacUploadImage.chooseImg'(findTestObject('Campaign_OR/Fields/m.button_company_logo'), mcompanyLogoPath + mcompanyLogo)
filepath = ''
//imgName = ''
if(GlobalVariable.os == 'Windows'){
	filepath = GlobalVariable.companyLogoPath
	//imgName = companyLogo
}else if (GlobalVariable.os == 'Mac'){
	filepath = GlobalVariable.mcompanyLogoPath
	//imgName = mcompanyLogo
}

verifyImgName = ''
uploadedImg = false
reuploadCount = 0

if(filepath.trim() != '' && companyLogo.trim() != ''){
	//CustomKeywords.'uploadFile.UploadImage.chooseImg'(GlobalVariable.os, findTestObject('Campaign_OR/Fields/m.button_company_logo'), filepath + companyLogo)
	
	WebUI.sendKeys(findTestObject('Campaign_OR/Fields/m.button_company_logo_1'), filepath + companyLogo)
	
	WebUI.delay(1)
	
	if(WebUI.waitForElementVisible(findTestObject('Campaign_OR/uploadedCompanyLogo'), 30)){
		verifyImgName = WebUI.getText(findTestObject('Campaign_OR/uploadedCompanyLogo'))
		
		if (verifyImgName.equals(companyLogo) == true) {
			uploadedImg = true
		} else if (uploadedImg == false) {
			throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong with the upload file.')
			//if(reuploadCount < maxReupload){
			//	CustomKeywords.'uploadFile.CancelUpload.pressDelete'()
			//	CustomKeywords.'uploadFile.UploadImage.chooseImg'(GlobalVariable.os, findTestObject('Campaign_OR/Fields/m.button_company_logo'), filepath + companyLogo)
			//	reuploadCount++
			//}else {
			//	throw new com.kms.katalon.core.exception.StepErrorException('Something wents wrong with the upload file.')
			//}
		}
	}
}


if (rewardCode == true) {
    WebUI.click(findTestObject('Campaign_OR/Fields/o.label_Yes'))
} else if (rewardCode == false) {
    WebUI.click(findTestObject('Campaign_OR/Fields/n.label_No'))
}

WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/radio_No'), 1, FailureHandling.OPTIONAL)

WebUI.verifyElementChecked(findTestObject('Campaign_OR/Fields/radio_Yes'), 1, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Campaign_OR/button_Save'))

WebUI.delay(2)

//WebUI.click(findTestObject('Campaign_OR/button_Cancel'))
