package TestCases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.LandingPage;
import resources.base;

public class trainScheduleInvalid extends base{
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\trainSchedule.xlsx";
	String testExecution="C:\\\\Users\\\\Avantika\\\\eclipse-workspace\\\\E2E.IRCTC\\\\src\\\\test\\\\java\\\\TestData\\\\testCaseExecution.xlsx";
	
	@BeforeTest
	
	public void initialize() throws Exception {
		//driver = initializeDriver();
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(8, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 8, 2);
			throw new SkipException ("Test Case is skipped");
		}
		
		
	}
	
	@Test
	
	public void trainSchedule() throws Exception {
		
		//driver.get(prop.getProperty("url"));
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		//PaymentPage bookTicket = new PaymentPage(driver);
		Actions action=new Actions(driver);
		action.moveToElement(landPage.Trains()).build().perform();
		landPage.schedule().click();
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"trainScheduleInvalid");
		
		String trainNumber=reader.getCellData(1, 1);
		
		landPage.trainInput().sendKeys(trainNumber);
		Thread.sleep(2000);
		landPage.searchButton().click();
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		reader1.setCellData(testExecution, "Pass", 8, 2);
		
		Thread.sleep(7000);
		
	}
	
	@AfterTest 
	
	public void tearDown() {
		driver.quit();
	}
	

}
