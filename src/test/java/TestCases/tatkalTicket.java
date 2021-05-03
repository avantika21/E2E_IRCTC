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

public class tatkalTicket extends base{
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\ticketBooking.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";

	@BeforeTest
	public void initialize() throws Exception {
	

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(2, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 2, 2);
			throw new SkipException ("Test Case is skipped");
		}
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));
	}

	@Test
	public void bookTicket() throws Exception {

		
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		landPage.loginClick().click();

		LoginPage login = new LoginPage(driver);
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		login.username().sendKeys(Username);
		Thread.sleep(2000);

		login.password().sendKeys(Password);

		Thread.sleep(19000);

		login.signin().click();
		Thread.sleep(5000);
		
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path, "ticketBook");
		String originCity=reader.getCellData(2, 1);
		String destinationCity=reader.getCellData(2, 2);
		String journeyQuota=reader.getCellData(2, 3);
		String journeyDate=reader.getCellData(2, 4);
		String journeyClass=reader.getCellData(2, 5);
		

		TrainBookingPage ticket = new TrainBookingPage(driver);
		ticket.originCity(originCity);

		Thread.sleep(1000);

		List<WebElement> dpListValues = ticket.originDropdown().findElements(By.xpath(".//li"));

		WebDriverWait waito = new WebDriverWait(driver, 20);
		waito.until(ExpectedConditions.visibilityOf(ticket.originDropdown()));

		for (int i = 0; i < dpListValues.size(); i++) {

			if ((dpListValues.get(i).getText()).startsWith(originCity)) {

				dpListValues.get(i).click();
				break;
			}
		}

		ticket.destinationCity(destinationCity);

		Thread.sleep(1000);
		List<WebElement> dest = ticket.destinationDropdown().findElements(By.xpath(".//li"));

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

		//List<WebElement> yes = trainList.yesButton();
		//int websize = yes.size();

		//System.out.println(websize);
		//if (websize > 0) {
			//yes.get(0).click();
		//}

		TrainPassengerDetailsPage passengerDetails = new TrainPassengerDetailsPage(driver);
	
		String name = reader.getCellData(2, 6);
		String age = reader.getCellData(2, 7);
		String gender = reader.getCellData(2, 8);
		String mobileNo = reader.getCellData(2, 9);
		String address1 = reader.getCellData(2, 10);
		String address2 = reader.getCellData(2, 11);
		String pincode = reader.getCellData(2, 12);
		String postOffice = reader.getCellData(2, 13);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", passengerDetails.passengerName());

		passengerDetails.passengerName().sendKeys(name);
		Thread.sleep(1000);
		passengerDetails.passengerAge().sendKeys(age);
		Thread.sleep(1000);
		Select genderP = new Select(passengerDetails.passengerGender());
		genderP.selectByVisibleText(gender);
		Thread.sleep(1000);
		passengerDetails.passengerMobile().sendKeys(mobileNo);
		Thread.sleep(1000);
		passengerDetails.address1().sendKeys(address1);
		Thread.sleep(1000);
		passengerDetails.address2().sendKeys(address2);
		Thread.sleep(1000);
		passengerDetails.pincode().sendKeys(pincode);
		Thread.sleep(1000);

		passengerDetails.state().click();

		Select postOfficeP = new Select(passengerDetails.postOffice());
		postOfficeP.selectByVisibleText(postOffice);
		//Thread.sleep(1000);
		
		
		
		List <WebElement> insurance = passengerDetails.travelInsurance();
		System.out.println(insurance.size());
		if(insurance.size() > 0) {
			insurance.get(0).click();
		}
		

		jse.executeScript("arguments[0].scrollIntoView()", passengerDetails.continueButton());

		passengerDetails.continueButton().click();

		Thread.sleep(6000);
		TrainReviewPage review = new TrainReviewPage(driver);

		String expectedOrigin= review.expectedOrigin().getText();
		Assert.assertTrue(expectedOrigin.contains(originCity));
		reader.setCellData(Path, expectedOrigin, 2, 14);
		
		String expectedDestination= review.expectedDestination().getText();
		Assert.assertTrue(expectedDestination.contains(destinationCity));
		reader.setCellData(Path, expectedDestination, 2, 15);
		
		String expectedClass= review.expectedClass().getText();
		Assert.assertTrue(expectedClass.contains(journeyClass));
		reader.setCellData(Path, expectedClass, 2, 16);
	
		String expectedQuota= review.expectedQuota().getText();
		Assert.assertTrue(expectedQuota.contains(journeyQuota));
		reader.setCellData(Path, expectedQuota, 2, 17);
		
		String expectedDate= review.expectedDate().getText();
		//Assert.assertTrue(expectedDate.contains(journeyDate));
		reader.setCellData(Path, expectedDate, 2, 18);
		
		String expectedName= review.expectedName().getText();
		Assert.assertTrue(expectedName.contains(name));
		reader.setCellData(Path, expectedName, 2, 19);
		
		String expectedAge= review.expectedAge().getText();
		Assert.assertTrue(expectedAge.contains(age));
		reader.setCellData(Path, expectedAge, 2, 20);
		
		String expectedGender= review.expectedGender().getText();
		Assert.assertTrue(expectedGender.contains(gender));
		reader.setCellData(Path, expectedGender, 2, 21);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		if(expectedOrigin.contains(originCity) && expectedDestination.contains(destinationCity) && expectedClass.contains(journeyClass) && 
				expectedQuota.contains(journeyQuota) && expectedDate.contains(journeyDate) && expectedName.contains(name) && 
				expectedAge.contains(age) && expectedGender.contains(gender)) 
		{
			reader1.setCellData(testExecution, "Pass", 2, 2);
			
		}
		
		else {
			reader1.setCellData(testExecution, "Fail", 2, 2);
		}
		

		
		jse.executeScript("arguments[0].scrollIntoView()", review.cancellation());
		Thread.sleep(15000);

		review.continueButton().click();

		Thread.sleep(5000);
		

	}

	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}

