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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class Excel {

	@Keyword
	def excel_code () {

		def data = findTestData('Test Data')
		int rowCount = data.getRowNumbers()

		for (int i = 1; i <= rowCount; i++) {

			return [
				'SBU': data.getValue('SBU', 1),
				'Location': data.getValue('Location', 1),
				'Financial_Year': data.getValue('Financial_Year', 1),
				'Location_1': data.getValue('Location_1', 1),
				'Reviewer': data.getValue('Reviewer', 1),
				'Lead_Auditor': data.getValue('Lead_Auditor', 1),
				'Audit_Type': data.getValue('Audit_Type', 1),
				'Audit_Team': data.getValue('Audit_Team', 1),
				'Plan': data.getValue('Plan', 1),
				'Process': data.getValue('Process', 1),
				'Scope': data.getValue('Scope', 1),
				'Background': data.getValue('Background', 1)
			]

		}
	}
	
}
