import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.LocalDate as LocalDate
import java.time.temporal.TemporalAdjusters as TemporalAdjusters
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

CustomKeywords.'Login.auditor_workspace'()

def excelData = CustomKeywords.'Excel.excel_code'()

GlobalVariable.Process = (excelData['Process'])

GlobalVariable.Scope = (excelData['Scope'])

GlobalVariable.Background = (excelData['Background'])

// Get first & last day
String firstDay = LocalDate.now().withDayOfMonth(1).getDayOfMonth().toString()

String lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth().toString()

WebUI.click(findTestObject('From_date_review_period'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 1)

// Click the first date (always 1)
TestObject firstDate = new TestObject()

firstDate.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + firstDay) + '\']')

WebUI.click(firstDate)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('To_date_review_period'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 1)

// Click last date (dynamic 28–31)
TestObject lastDate = new TestObject()

lastDate.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + lastDay) + '\']')

WebUI.click(lastDate)

WebUI.switchToDefaultContent()

WebUI.sendKeys(findTestObject('Process_text-field'), GlobalVariable.Process)

WebUI.switchToFrame(findTestObject('iframe_Scope_Field'), 6)

WebUI.sendKeys(findTestObject('Audit_scope_ck_editor'), GlobalVariable.Scope)

WebUI.switchToDefaultContent()

WebUI.switchToFrame(findTestObject('iframe_Background_field'), 0)

WebUI.sendKeys(findTestObject('Background_ck_editor'), GlobalVariable.Background)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('subscribe_audit_icon'))

WebUI.switchToFrame(findTestObject('iframe_Pick Auditee and Escalator__iframe-UserBox'), 6)

WebUI.click(findTestObject('Region_btnReset'))

WebUI.setText(findTestObject('empID'), 'ETD02')

WebUI.click(findTestObject('Region_btnSearch'))

WebUI.click(findTestObject('chk'))

WebUI.click(findTestObject('btnAddToList'))

WebUI.click(findTestObject('done_button'))

WebUI.switchToDefaultContent()

WebUI.selectOptionByLabel(findTestObject('allow_peers_access'), 'Yes', false)

WebUI.selectOptionByLabel(findTestObject('select_auditor_peers_access'), GlobalVariable.Lead_Auditor, false)

WebUI.click(findTestObject('From_date_actual_audit_from'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 1)

firstDate.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + firstDay) + '\']')

WebUI.click(firstDate)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('To_date_actual_audit_From'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 1)

lastDate.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + lastDay) + '\']')

WebUI.click(lastDate)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Save_button_general_info'))

WebUI.acceptAlert()
