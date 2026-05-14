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
import com.kms.katalon.objectspy.element.WebElement as WebElement
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Select_audit_area'))

WebUI.setText(findTestObject('Select_Audit_Area_Audit Area'), GlobalVariable.audit_area)

WebUI.click(findTestObject('Manage_audit_areas_btnFilter'))

WebUI.click(findTestObject('checkbox_audit_area'))

WebUI.clearText(findTestObject('no_of_times'))

WebUI.setText(findTestObject('no_of_times'), '2')

WebUI.click(findTestObject('Save_Ticked_audit_Areas_to_annual_audit_area'))

List<WebElement> dropdowns = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, '/html/body/form[2]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td[4]/table/tbody/tr/td/select'), 
    10)

def excelData = CustomKeywords.'Excel.excel_code'()
GlobalVariable.Reviewer = (excelData['Reviewer'])
GlobalVariable.Lead_Auditor = (excelData['Lead_Auditor'])
GlobalVariable.Audit_Type = (excelData['Audit_Type'])
GlobalVariable.Audit_Team = (excelData['Audit_Team'])
GlobalVariable.Location = (excelData['Location'])
GlobalVariable.Location_1 = (excelData['Location_1'])
GlobalVariable.Plan = (excelData['Plan'])

def values = [GlobalVariable.Reviewer, GlobalVariable.Lead_Auditor, GlobalVariable.Audit_Type, GlobalVariable.Audit_Team
    , GlobalVariable.Reviewer, GlobalVariable.Lead_Auditor, GlobalVariable.Audit_Type, GlobalVariable.Audit_Team]

for (int i = 0; i < dropdowns.size(); i++) {
    TestObject dynamic = new TestObject()

    dynamic.addProperty('xpath', ConditionType.EQUALS, ('(/html/body/form[2]/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td[4]/table/tbody/tr/td/select)[' + 
        (i + 1)) + ']')

    WebUI.selectOptionByLabel(dynamic, values[i], false)
}

List<WebElement> search = WebUI.findWebElements(new TestObject().addProperty('xpath', ConditionType.EQUALS, '//input[@type=\'text\']'), 
    10)

values = [GlobalVariable.Location, GlobalVariable.Location_1]

for (int i = 0; i < values.size(); i++) {
    dynamic = new TestObject()

    dynamic.addProperty('xpath', ConditionType.EQUALS, ('(//input[@type=\'text\'])[' + (i + 1)) + ']')

    // Correct way — pass value one by one
    WebUI.setText(dynamic, values[i])

    dynamic.addProperty('xpath',ConditionType.EQUALS,"(//label[contains(normalize-space(),'"+values[i]+"')]/preceding-sibling::input[@type='checkbox'])[" + (i + 1) + "]")

    WebUI.click(dynamic)
}

WebUI.click(findTestObject('Save_Annual_Audit_Plan'))

WebUI.click(findTestObject('Back_to_audit_planning'))

