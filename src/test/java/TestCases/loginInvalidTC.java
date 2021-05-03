package TestCases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import resources.base;

public class loginInvalidTC extends base{

	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\loginTestCase.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";

	
	@BeforeTest
	
	public void initialize() throws Exception {
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		String runMode=reader.getCellData(4, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 4, 2);
			throw new SkipException ("Test Case is skipped");
		}	
		
		//driver=initializeDriver();
				
	}
	
	@Test
	
	public void basePageNavigation() throws Exception {
		//driver.get(prop.getProperty("url"));
		LandingPage landPage=new LandingPage(driver);
		landPage.alertClick().click();
		landPage.loginClick().click();
		
		LoginPage login =new LoginPage(driver);
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"loginInvalid");
		String Username=reader.getCellData(1, 1);
		String Password=reader.getCellData(1, 2);
		login.username().sendKeys(Username);
	    Thread.sleep(2000);
		
		login.password().sendKeys(Password);
		
		Thread.sleep(20000);
		
		login.signin().click();
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		reader1.setCellData(testExecution, "Pass", 4, 2);
		
		Thread.sleep(5000);
	}
	
	@AfterTest
	
	public void tearDown() {
		driver.quit();
	}
}
