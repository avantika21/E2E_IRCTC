package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.LandingPage;

import resources.base;

public class trainTrackValid extends base {

	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\trainTrack.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";
	
	@BeforeTest

	public void initialize() throws Exception {
		//driver = initializeDriver();
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(10, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 10, 2);
			throw new SkipException ("Test Case is skipped");
		}

	}

	@Test
	public void trainTracking() throws Exception {

		//driver.get(prop.getProperty("url"));
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		//PaymentPage bookTicket = new PaymentPage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(landPage.Trains()).build().perform();
		landPage.trainTrack().click();
		
		//String parentWindow= driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
		    driver.switchTo().window(currentWindow);
		}
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"trainTrackValid");
		
		String trainNumber=reader.getCellData(1, 1);
		
		landPage.trainNum().sendKeys(trainNumber);
		Thread.sleep(3000);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		reader1.setCellData(testExecution, "Pass", 10, 2);
		
		
		Thread.sleep(5000);
		
		//bookTicket.newSearch().click();
		
		

	}
@AfterTest 
	
	public void tearDown() {
		driver.quit();
	}
	
}
