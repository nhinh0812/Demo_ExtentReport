package Excution_Engine;

import org.junit.Ignore;
import org.junit.Test;

import Utilities.ActionKeywords;
import Utilities.ExcelUtils;
import Utilities.Log;

public class TestScriptSearch {
	@Test
	public void excute_TestCaseSearch() throws Exception {
		Log.info("=========Chạy testcase tìm kiếm==========");

		String sPath = System.getProperty("user.dir") + "//src//main//java//Data_Engine//Data_Search.xlsx";
		ExcelUtils.setExcelFile(sPath, "Search");
		int CasePass = 0;
		int CaseFail = 0;
		int CaseSkip = 0;
		for (int iRow = 1; iRow <= ExcelUtils.getRowCount("Search"); iRow++) {
			
				System.out.println(iRow);
				String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
				String locatorType = ExcelUtils.getCellData(iRow, 6);

				String locatorValue = ExcelUtils.getCellData(iRow, 7);
				String testData = ExcelUtils.getCellData(iRow, 8);

				switch (sActionKeyword) {
				case "openBrowser":
//					Log.info(testData);
					ActionKeywords.openBrowser(testData);				
					break;		
				case "navigate":
					ActionKeywords.navigate(testData);
					break;
				case "setText":
					ActionKeywords.setText(locatorType, locatorValue, testData);
					break;
//				case "click":
//					ActionKeywords.clickElement(locatorType, locatorValue);
//					break;
				case "clickSearch":
					ActionKeywords.clickElement(locatorType, locatorValue);
					break;
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
				case "quitBrowser":
					ActionKeywords.quitDriver();
					break;
				default:
//					System.out.println("[>>ERROR<<]: |Keyword Not Found " + sActionKeyword);
					Log.error("|Keyword Not Found " + sActionKeyword);
				
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
//	@Ignore
//	public void excute_TestCaseSearchFail() throws Exception {
//		Log.info("Chạy testcase tìm kiếm fail");
//
//		String sPath = System.getProperty("user.dir") + "//src//main//java//Data_Engine//Data_Search.xlsx";
//		ExcelUtils.setExcelFile(sPath, "Search");
//
//		for (int iRow = 1; iRow <= 12; iRow++) {
//			
//				System.out.println(iRow);
//				String sActionKeyword = ExcelUtils.getCellData(iRow, 2);
//				String locatorType = ExcelUtils.getCellData(iRow, 4);
//
//				String locatorValue = ExcelUtils.getCellData(iRow, 6);
//				String testData = ExcelUtils.getCellData(iRow, 7);
//
//				switch (sActionKeyword) {
//				case "openBrowser":
////					Log.info(testData);
//					ActionKeywords.openBrowser(testData);
//					
//					break;
//				
//				case "navigate":
//					ActionKeywords.navigate(testData);
//					break;
//				case "setText":
//					ActionKeywords.setText(locatorType, locatorValue, testData);
//					break;
////				case "click":
////					ActionKeywords.clickElement(locatorType, locatorValue);
////					break;
//				case "clickSearch":
//					ActionKeywords.clickElement(locatorType, locatorValue);
//					break;
////				case "verifyLabel":
////					ActionKeywords.verifyElementText(locatorType, locatorValue, testData);
////					break;
//				case "verifyLabel":
//					if (ActionKeywords.verifyLabel(locatorType, locatorValue, testData)) {
//						Log.info("=========================");
//						Log.info("Same result ---> pass");
//						Log.info("=========================");
//						CasePass++;
//					} else {
//						Log.info("=========================");
//						Log.info("Different result ---> Fail");
//						Log.info("=========================");
//						CaseFail++;
//					}
//					break;
//				case "quitBrowser":
//					ActionKeywords.quitDriver();
//					break;
//				default:
////					System.out.println("[>>ERROR<<]: |Keyword Not Found " + sActionKeyword);
//					Log.error("|Keyword Not Found " + sActionKeyword);
//				}
//			}
}
