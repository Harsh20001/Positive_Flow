import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Login {

	@Keyword
	def AppLogin () {
				
		WebUI.navigateToUrl('http://10.0.77.99/LARS_Adityabirla/loginet.aspx')
		
		WebUI.setText(findTestObject('username'), 'admin')
		
		WebUI.setText(findTestObject('password'), 'a')
		
		WebUI.click(findTestObject('Login_button'))
		
	}
	
	@Keyword
	def reviewer_login () {
				
		WebUI.navigateToUrl('http://10.0.77.99/LARS_Adityabirla/loginet.aspx')
		
		WebUI.setText(findTestObject('username'), 'etd02')
		
		WebUI.setText(findTestObject('password'), 'a')
		
		WebUI.click(findTestObject('Login_button'))
		
	}
	
	@Keyword
	def auditor_workspace () {
		
		WebUI.click(findTestObject('a_Logout'))
				
		reviewer_login()  // For login into auditor
		
		boolean test
		
		WebUI.click(findTestObject('AUDITORS_workspace_tab'))
		
		WebUI.click(findTestObject('td_Auditors Workspace'))
		
		WebUI.click(findTestObject('View_Modify_Annual_auditFILTER_icon'))
		
		def labels1 = ['Quarter', 'SBU', 'Location', 'Audit Type']
		
		def values = [GlobalVariable.Quarter, GlobalVariable.SBU, GlobalVariable.Location, GlobalVariable.Audit_Type]
		
		for (int i = 0; i < labels1.size(); i++) {
			String label = labels1[i]
		
			String value = values[i]
		
			if ((value != null) && (value.trim() != '')) {
				// 🔹 Click dropdown using label (NOT index) ,
				TestObject dropdown = new TestObject()
		
				dropdown.addProperty('xpath', ConditionType.EQUALS, (('//*[self::label or self::strong][contains(normalize-space(),\'' +
					label) + '\')]') + '/following::a[contains(@class,\'chosen-single\')]')
		
				WebUI.waitForElementClickable(dropdown, 10)
		
				WebUI.click(dropdown)
		
				// 🔹 Select option
				TestObject option = new TestObject()
		
				option.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@class,\'active-result\') and normalize-space()=\'' +
					value) + '\']')
		
				WebUI.waitForElementClickable(option, 10)
		
				WebUI.click(option)
			}
			
		}
		
		WebUI.click(findTestObject('input_Audit Area_default'))
		
		TestObject option1 = new TestObject()
		
		option1.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@class,\'active-result\') and normalize-space()=\'' +((GlobalVariable.audit_area + ' (') + GlobalVariable.SBU) + ')' + '\']'))
		
		WebUI.waitForElementClickable(option1, 10)
		
		WebUI.click(option1)
		
		WebUI.click(findTestObject('filter_auditor_workspace'))
		
		WebUI.click(findTestObject('show_all_columns_auditors_workspace'))
		
		String sbu_workspace = WebUI.getText(findTestObject('sbu_auditors_workspace'))
		
		String audit_workspace = WebUI.getText(findTestObject('audit_area_auditors_workspace'))
		
		String location_workspace = WebUI.getText(findTestObject('Location_auditors_workspace'))
		
		String audit_type_workspace = WebUI.getText(findTestObject('Audit_Type_Auditors_workspace'))
		
		String lead_auditor_workspace = WebUI.getText(findTestObject('Lead_auditor_auditors_workspace'))
		
		String reviewer_workspace = WebUI.getText(findTestObject('Reviewer_Auditors_workspace'))
		
		if (sbu_workspace.contains(GlobalVariable.SBU) && audit_workspace.contains(GlobalVariable.audit_area) && location_workspace.contains(GlobalVariable.Location)) {
			
			test = true;
			WebUI.click(findTestObject('radio_button_auditors_workspace'))
				
		} else {
			
			test = false;
			WebUI.click(findTestObject('radio_button_auditors_workspace'))
		}
	}
	
	@Keyword
	def send_for_review () {
				
		WebUI.selectOptionByLabel(findTestObject('select_reviewer'), GlobalVariable.Lead_Auditor, false)
		
		WebUI.setText(findTestObject('txtRemarks'), 'Changing Lead auditor')
		
		WebUI.click(findTestObject('send_for_review'))
		
		WebUI.click(findTestObject('close_change_auditor'))
		
		WebUI.click(findTestObject('a_Logout'))
		
		CustomKeywords.'Login.reviewer_login'()
		
		WebUI.click(findTestObject('approve'))
		
		WebUI.click(findTestObject('Notifications'))
		
		WebUI.click(findTestObject('filter_icon_notification_tab'))
		
		String auditArea = GlobalVariable.audit_area
		
		// Extract only the date part
		String datePart = auditArea.replace('audit area ', '').split(' ')[0]
		
		// Convert 2026 -> 20
		String shortYear = datePart.substring(0, datePart.lastIndexOf('_') + 1) + '20'
		
		String finalValue = ((('audit area ' + shortYear) + ' (') + GlobalVariable.SBU) + ')'
		
		def labels = ['Audit Area']
		
		def values = [finalValue]
		
		for (int i = 0; i < labels.size(); i++) {
		    String label = labels[i]
		
		    String value = values[i]
		
		    if ((value != null) && (value.trim() != '')) {
		        // 🔹 Click dropdown using label (NOT index)
		        TestObject dropdown = new TestObject()
		
		        dropdown.addProperty('xpath', ConditionType.EQUALS, (('//*[self::label or self::strong][contains(normalize-space(),\'' + 
		            label) + '\')]') + '/following::a[contains(@class,\'chosen-single\')]')
		
		        WebUI.waitForElementClickable(dropdown, 10)
		
		        WebUI.click(dropdown)
		
		        // 🔹 Select option
		        TestObject option = new TestObject()
		
		        option.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@class,\'active-result\') and normalize-space()=\'' + 
		            value) + '\']')
		
		        WebUI.waitForElementClickable(option, 10)
		
		        WebUI.click(option)
		    }
		}
		
		WebUI.click(findTestObject('filter_button_notification'))
		
		WebUI.click(findTestObject('a_Approval for Lead Auditor Changed'))
		
		WebUI.click(findTestObject('approve_button'))
		
		WebUI.acceptAlert()
		
	}
}
