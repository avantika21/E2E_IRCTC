package TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.SystemNanoClock;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.TrainBookingPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.TrainPassengerDetailsPage;
import pageObjects.TrainReviewPage;
import pageObjects.TrainListPage;
import resources.base;

public class bookWithoutLogin extends base {
	
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\ticketBooking.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";
	
	@BeforeTest

	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(14, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 14, 2);
			throw new SkipException ("Test Case is skipped");
		}
		
		
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));

	}

	@Test
	public void bookTicket() throws Exception {

		
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		//landPage.loginClick().click();
		LoginPage login = new LoginPage(driver);
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		//login.username().sendKeys(Username);
		//Thread.sleep(2000);

		//login.password().sendKeys(Password);

		//Thread.sleep(19000);

		//login.signin().click();
		Thread.sleep(5000);
		
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path, "ticketBook");
		String originCity=reader.getCellData(1, 1);
		String destinationCity=reader.getCellData(1, 2);
		String journeyQuota=reader.getCellData(1, 3);
		String journeyDate=reader.getCellData(1, 4);
		String journeyClass=reader.getCellData(1, 5);
		

		TrainBookingPage ticket = new TrainBookingPage(driver);
		ticket.originCity(originCity);

		Thread.sleep(1000);

		List<WebElement> dpListValues = ticket.bookWithoutLoginOrigin().findElements(By.xpath(".//li"));

		//WebDriverWait waito = new WebDriverWait(driver, 20);
		//waito.until(ExpectedConditions.visibilityOf(ticket.originDropdown()));

		for (int i = 0; i < dpListValues.size(); i++) {

			if ((dpListValues.get(i).getText()).startsWith(originCity)) {

				dpListValues.get(i).click();
				break;
			}
		}

		ticket.destinationCity(destinationCity);

		Thread.sleep(1000);
		List<WebElement> dest = ticket.bookWithoutLoginDest().findElements(By.xpath(".//li"));

		for (int i = 0; i < dest.size(); i++) {

			if ((dest.get(i).getText()).startsWith(destinationCity)) {
				dest.get(i).click();
				break;
			}
		}

		Thread.sleep(3000);

		// ticket.calender().clear();
		// ticket.calender().sendKeys(journeyDate);

		ticket.quota().click();

		// WebDriverWait wait=new WebDriverWait(driver,30);
		// List<WebElement> quota =
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(quotaDropdown));
		// List<WebElement> quota=ticket.quotaDropdown();
		Thread.sleep(2000);
		List<WebElement> quota = ticket.quotaDropdown().findElements(By.tagName("p-dropdownitem"));

		System.out.println(quota.size());
		Thread.sleep(2000);
		for (int i = 0; i < quota.size(); i++) {

			String text = quota.get(i).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(journeyQuota)) {
				quota.get(i).click();
				break;
			}

		}

		//List<WebElement> okButton=ticket.okButton();
		//System.out.println(okButton.size());
		//if(okButton.size() >0) {
			//okButton.get(0).click();
		//}
		
		
		
		ticket.calender().click();

		Thread.sleep(2000);

		List<WebElement> date = ticket.dateSelect();
		System.out.println(date.size());
		for (int i = 0; i < date.size(); i++) {

			String dateValue = date.get(i).getText();

			if (dateValue.equals(journeyDate)) {
				date.get(i).click();
				break;
			}

		}
		
		Thread.sleep(2000);
		
		//List<WebElement> okButton1=ticket.okButton();
		//System.out.println(okButton1.size());
		//if(okButton1.size() >0) {
		//	okButton1.get(0).click();
		//}

		Thread.sleep(3000);
		 ticket.exchange().click();

		 Thread.sleep(3000);
		 ticket.exchange().click();

		ticket.availableBerth().click();
		Thread.sleep(3000);
		ticket.searchButton().click();
		Thread.sleep(6000);
		
		//List<WebElement> okButton2=ticket.okButton();
		//System.out.println(okButton2.size());
		//if(okButton2.size() >0) {
		//	okButton2.get(0).click();
		//}
		
		
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		TrainListPage trainList = new TrainListPage(driver);

		List<WebElement> available = trainList.available();
		int size1 = available.size();
		// System.out.println(size1);

		List<WebElement> classType = trainList.classType();

		int size2 = classType.size();
		// System.out.println(size2);

		for (int i = 0; i < size1; i++) {
			String availableTrain = available.get(i).getText();
			System.out.println(availableTrain);

			if (availableTrain.startsWith("AVAILABLE", 0)) {
				for (int j = 0; j < size2; j++) {
					String trainType = classType.get(j).getText();
					if (trainType.contains(journeyClass)) {

						JavascriptExecutor jse = (JavascriptExecutor) driver;
						jse.executeScript("arguments[0].scrollIntoView()", classType.get(j));

						Thread.sleep(2000);
						classType.get(j).click();
						break;

					}
				}
				break;
			}

		}

		Thread.sleep(2000);

		trainList.bookNow().click();
		Thread.sleep(1000);
		trainList.agreeButton().click();

		Thread.sleep(10000);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		reader1.setCellData(testExecution, "Pass", 14, 2);
	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}


}
