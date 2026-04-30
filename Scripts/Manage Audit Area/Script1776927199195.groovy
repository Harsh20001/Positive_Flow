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

WebUI.click(findTestObject('audit_planning'))

WebUI.click(findTestObject('Manage Audit Area'))

def excelData = CustomKeywords.'Excel.excel_code'()

GlobalVariable.SBU = (excelData['SBU'])

String[] values1 = [GlobalVariable.SBU, 'Active']

for (int i = 0; i < values1.length; i++) {
    // Step 1: Identify each dropdown dynamically
    TestObject dropdown = new TestObject()

    dropdown.addProperty('xpath', ConditionType.EQUALS, ('(//a[contains(@class,\'chosen-single\')])[' + (i + 1)) + ']')

    // Step 3: Click dropdown
    WebUI.click(dropdown)

    // Step 4: Wait for options
    WebUI.delay(1)

    // Step 5: Select value (Chosen dropdown option)
    TestObject option = new TestObject()

    option.addProperty('xpath', ConditionType.EQUALS, ('//li[contains(@class,\'active-result\') and normalize-space(text())=\'' + 
        (values1[i])) + '\']')

    WebUI.click(option)
}

WebUI.setText(findTestObject('Manage_audit_areas_Audit Area Name'), GlobalVariable.audit_area)

WebUI.click(findTestObject('Manage_audit_areas_btnFilter'))

WebUI.click(findTestObject('Manage_Audit_areas_btnExport'))

WebUI.click(findTestObject('Manage_audit_Areas_btnreset'))

WebUI.click(findTestObject('audit_planning'))

