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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.junit.Assert as Assert
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import internal.GlobalVariable as GlobalVariable

boolean test

def excelData = CustomKeywords.'Excel.excel_code'()

GlobalVariable.SBU = (excelData['SBU'])

println(GlobalVariable.SBU)

WebUI.click(findTestObject('Add audit area'))

WebUI.selectOptionByLabel(findTestObject('select_sbu_audit_area'), GlobalVariable.SBU, false)

LocalDateTime now = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('dd_MM_yyyy HH_mm')

GlobalVariable.audit_area = ('audit area ' + now.format(formatter))

WebUI.setText(findTestObject('Audit Area Description'), GlobalVariable.audit_area)

WebUI.click(findTestObject('btnSave'))

WebUI.verifyElementText(findTestObject('Your newly added record have been sent'), 'Your newly added record have been sent for approval.')

WebUI.click(findTestObject('approve'))

WebUI.click(findTestObject('Approve Master'))

WebUI.selectOptionByLabel(findTestObject('Action'), 'New Addition', false)

WebUI.click(findTestObject('modified_on'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 1);

WebUI.waitForElementClickable(findTestObject('Today'), 5)

WebUI.click(findTestObject('Today'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('filter'))

String audit = WebUI.getText(findTestObject('Area name'))

println(audit)

String company_name = WebUI.getText(findTestObject('Company_name'))

String sbu = WebUI.getText(findTestObject('SBU_name'))

if ((audit.equals(GlobalVariable.audit_area) && company_name.equals(GlobalVariable.SBU)) && sbu.equals(GlobalVariable.SBU)) {
    test = true

    Assert.assertTrue(test)
} else {
    test = false

    Assert.assertTrue(test)
}

WebUI.click(findTestObject('View Details'))

WebUI.switchToFrame(findTestObject('iframe_Pick Auditee__iframe-UserBox'), 1);

audit = WebUI.getText(findTestObject('view_details_audit_area'))

company_name = WebUI.getText(findTestObject('View_details_company_name'))

sbu = WebUI.getText(findTestObject('View_details_sbu_name'))

if ((audit.equals(GlobalVariable.audit_area) && company_name.equals(GlobalVariable.SBU)) && sbu.equals(GlobalVariable.SBU)) {
    test = true

    WebUI.click(findTestObject('btnClose'))

	WebUI.switchToDefaultContent()
	
    WebUI.click(findTestObject('checkbox'))

    WebUI.click(findTestObject('Accept'))

    WebUI.acceptAlert()

    WebUI.callTestCase(findTestCase('Manage Audit Area'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Select audit Area'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Assign Audits'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('View Modify Annual Audit Plan'), [:], FailureHandling.STOP_ON_FAILURE)

    Assert.assertTrue(test)
} else {
    test = false

    WebUI.click(findTestObject('btnClose'))

	WebUI.switchToDefaultContent()
	
    WebUI.click(findTestObject('checkbox'))

    WebUI.click(findTestObject('Accept'))

    WebUI.acceptAlert()

    WebUI.callTestCase(findTestCase('Manage Audit Area'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Select audit Area'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Assign Audits'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('View Modify Annual Audit Plan'), [:], FailureHandling.STOP_ON_FAILURE)

    Assert.assertTrue(test)
}

