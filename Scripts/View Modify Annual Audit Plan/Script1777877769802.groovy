import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filters'()

// View Details

WebUI.click(findTestObject('view_derails_icon'))

WebUI.click(findTestObject('close_icon'))

// Export to Excel

WebUI.click(findTestObject('export_to_excel_view_modify_annual_audit'))

// Lock Audit

WebUI.click(findTestObject('Lock_Audit_button'))

WebUI.click(findTestObject('Next_button'))

WebUI.click(findTestObject('input_Status_checkbox_lock_annual_Audit'))

WebUI.click(findTestObject('Lock_Selected_Audits'))

WebUI.acceptAlert()

// Un-Lock Audit

WebUI.click(findTestObject('back_button_lock_annual_audit'))

WebUI.click(findTestObject('radio_button_unlock_audit'))

WebUI.click(findTestObject('Next_button'))

WebUI.click(findTestObject('input_Status_checkbox_lock_annual_Audit'))

WebUI.click(findTestObject('Lock_Selected_Audits'))

WebUI.acceptAlert()

String unlock = WebUI.getText(findTestObject('Audits Un-locked Successfully'))

WebUI.click(findTestObject('audit_planning'))

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filters'()

// Import Functionality

WebUI.click(findTestObject('btn_import_view_modify_annual_Audit'))

WebUI.click(findTestObject('Download Sample File_view_modify_annual_audit_plan'))

//WebUI.uploadFile(findTestObject('UsersFUpload_view_modify_annual_audit_plan'), '')

//WebUI.click(findTestObject('btnImport_view_modify_annual_audit_plan'))

WebUI.click(findTestObject('input_Download Sample File_btnClose_view_modify_annual_plan'))

// Change new lead auditor

WebUI.click(findTestObject('change_lead_auditor_icon'))

WebUI.selectOptionByLabel(findTestObject('select_new_lead_auditor'), GlobalVariable.Lead_Auditor, false)

WebUI.click(findTestObject('save_change_auditor'))

CustomKeywords.'Login.send_for_review'()

WebUI.click(findTestObject('a_Logout'))

CustomKeywords.'Login.AppLogin'()

WebUI.click(findTestObject('audit_planning'))

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filters'()

// Drop Audit

WebUI.click(findTestObject('drop_audit_icon'))

WebUI.click(findTestObject('checkbox_for_drop_audit'))

WebUI.click(findTestObject('drop_audit_button'))

CustomKeywords.'Login.send_for_review'()

WebUI.click(findTestObject('a_Logout'))

CustomKeywords.'Login.AppLogin'()

WebUI.click(findTestObject('audit_planning'))

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filters'()

// Re-Activate_audit

WebUI.click(findTestObject('re_activate_audit'))

WebUI.click(findTestObject('checkbox_RE-ACTIVATE AUDIT AREA'))

WebUI.click(findTestObject('Re_activate_button'))

CustomKeywords.'Login.send_for_review'()

WebUI.click(findTestObject('a_Logout'))

CustomKeywords.'Login.AppLogin'()

WebUI.click(findTestObject('audit_planning'))

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filters'()

// Delete Audit

WebUI.click(findTestObject('Delete_audit_icon'))

WebUI.click(findTestObject('checkbox_DELETE AUDIT AREA'))

WebUI.click(findTestObject('Delete_audit_button'))

CustomKeywords.'Login.send_for_review'()

WebUI.click(findTestObject('a_Logout'))

CustomKeywords.'Login.AppLogin'()

WebUI.click(findTestObject('audit_planning'))

CustomKeywords.'Assign_audit_2nd.View_modify_annual_audit_plan_filter'()