package Excution_Engine;

import org.junit.Test;
import Utilities.Log;

import Utilities.ActionKeywords;
import Utilities.ExcelUtils;
public class TestScriptRegister {
	@Test
	public void excute_TestCaseDangKy() throws Exception {
		Log.info("=============Chạy testcase đăng ký==========");

		String sPath = System.getProperty("user.dir") + "//src//main//java//Data_Engine//Data_Register.xlsx";
		ExcelUtils.setExcelFile(sPath, "Register");
		int CasePass = 0;
		int CaseFail = 0;
		int CaseSkip = 0;
		for (int iRow = 1; iRow <= ExcelUtils.getRowCount("Register"); iRow++) {
			
				System.out.println(iRow);
				String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
				String locatorType = ExcelUtils.getCellData(iRow, 6);
				String ob=ExcelUtils.getCellData(iRow, 5);

				String locatorValue = ExcelUtils.getCellData(iRow, 7);
				String testData = ExcelUtils.getCellData(iRow, 8);

				switch (sActionKeyword) {
				case "openBrowser":
					ActionKeywords.openBrowser(testData);
					break;

				case "click":
					ActionKeywords.clickElement(locatorType, locatorValue);
					break;
				case "clickdk":
					ActionKeywords.clickElement(locatorType, locatorValue);
					break;
				
				case "navigate":
					ActionKeywords.navigate(testData);
					break;
				case "setText":
					ActionKeywords.setText(locatorType, locatorValue, testData);
					break;
				case "clickDangKy":
					ActionKeywords.clickElement(locatorType, locatorValue);
					break;
//				case "verifyLabel":
//					ActionKeywords.verifyElementText(locatorType, locatorValue, testData);
//					break;
				case "verifyLabel":
					if (ActionKeywords.verifyLabel(locatorType, locatorValue, testData)) {
						Log.info("=========================");
						Log.info("Same result ---> pass");
						Log.info("=========================");
						CasePass++;
					} else {
						Log.info("=========================");
						Log.info("Different result ---> Fail");
						Log.info("=========================");
						CaseFail++;
					}
					break;
				case "verifyMess":
					if (ActionKeywords.verifyMess(ob, testData)) {
					Log.info("=========================");
					Log.info("Same result ---> pass");
					Log.info("=========================");
					CasePass++;
				} else {
					Log.info("=========================");
					Log.info("Different result ---> Fail");
					Log.info("=========================");
					CaseFail++;
				}
				break;
				case "quitBrowser":
					ActionKeywords.quitDriver();
					break;
				default:
					Log.error("|Keyword Not Found|" + sActionKeyword);
				}
			}
		java.util.Date date = new java.util.Date();
		Log.info("==========================================================");
		Log.info("-----------" + date + "--------------");
		Log.info("Total number of Testcases run: " + (CasePass + CaseFail + CaseSkip));
		Log.info("Total number of passed Testcases: " + CasePass);
		Log.info("Total number of failed Testcases: " + CaseFail);
		Log.info("Total number of skip Testcases: " + CaseSkip);
		Log.info("==========================================================");
		}
}
