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

WebUI.click(findTestObject('Assign_Audits'))

def labels = ['Location', 'SBU', 'Audit Team', 'Audit Area']

def values = [GlobalVariable.Location, GlobalVariable.SBU, GlobalVariable.Audit_Team, ((GlobalVariable.audit_area + ' (') + 
    GlobalVariable.SBU) + ')']

for (int i = 0; i < labels.size(); i++) {
    String label = labels[i]

    String value = values[i]
	
	String clean = value.replaceAll('[ ()]', '')

    if ((value != null) && (value.trim() != '')) {
        // 🔹 Click dropdown using label (NOT index)
        TestObject dropdown = new TestObject()

        dropdown.addProperty('xpath', ConditionType.EQUALS, (('//*[self::label or self::strong][contains(normalize-space(),\'' + 
            label) + '\')]') + '/following::a[contains(@class,\'chosen-single\')]')

        WebUI.waitForElementClickable(dropdown, 10)

        WebUI.click(dropdown)

        // 🔹 Select option
        TestObject option = new TestObject()

        option.addProperty('xpath',ConditionType.EQUALS,"//li[contains(@class,'active-result') and contains(translate(., ' ()', ''), '"+clean+"')]")

        WebUI.waitForElementClickable(option, 10)

        WebUI.click(option)
    }
}

WebUI.click(findTestObject('Assign_audit_Area_filter_btn'))

WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight)', null)

WebUI.delay(2)

WebUI.click(findTestObject('From_date'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 2)

int firstDay = LocalDate.now().withDayOfMonth(1).getDayOfMonth()

println(firstDay)

TestObject dynamic = new TestObject()

dynamic.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + firstDay) + '\']')

WebUI.waitForElementPresent(dynamic, 2)

WebUI.click(dynamic)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('To_date'))

WebUI.switchToFrame(findTestObject('Iframe_From_date'), 2)

int lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth()

println(lastDay)

dynamic.addProperty('xpath', ConditionType.EQUALS, ('//a[text()=\'' + lastDay) + '\']')

WebUI.waitForElementPresent(dynamic, 0)

WebUI.click(dynamic)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('days_error'))

WebUI.setText(findTestObject('NoDays_auditor'), '3')

WebUI.setText(findTestObject('NoDays_reviewer'), '4')

WebUI.click(findTestObject('Planned_days_btnSave'))

WebUI.click(findTestObject('select_auditee'))

WebUI.switchToFrame(findTestObject('iframe_Pick Auditee and Escalator__iframe-UserBox'), 6);

WebUI.click(findTestObject('auditee_icon'))

WebUI.switchToFrame(findTestObject('iframe_Pick Auditee and Escalator__iframe-UserBox'), 6);

WebUI.click(findTestObject('Region_btnReset'))

WebUI.setText(findTestObject('empID'), 'ETD06')

WebUI.click(findTestObject('Region_btnSearch'))

WebUI.click(findTestObject('chk'))

WebUI.click(findTestObject('btnAddToList'))

WebUI.click(findTestObject('done_button'))

WebUI.switchToDefaultContent()

WebUI.switchToFrame(findTestObject('iframe_Pick Auditee and Escalator__iframe-UserBox'), 1);

WebUI.click(findTestObject('auto_fill_escalator'))

WebUI.click(findTestObject('Submit'))

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Save_and_Assign_Audit_Areas'))

CustomKeywords.'Assign_audit_2nd.Assign_2nd_audits'()

WebUI.click(findTestObject('audit_planning'))

