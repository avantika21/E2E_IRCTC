package TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.LandingPage;
import pageObjects.MaharajaBookingPage;
import pageObjects.MaharajaLandPage;
import pageObjects.MaharajaPassengerDetailsPage;
import pageObjects.MaharajaReviewPage;
import resources.base;

public class maharajaTrain extends base{
	
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\maharajaBooking .xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";
	

	
	@BeforeTest

	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		String runMode=reader.getCellData(6, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 6, 2);
			throw new SkipException ("Test Case is skipped");
		}
		
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void maharajaTrainBooking() throws Exception {
		
		
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		Actions action=new Actions(driver);
		action.moveToElement(landPage.holiday()).build().perform();
		Thread.sleep(1000);
		landPage.specialTrains().click();
		Thread.sleep(500);
		landPage.maharajaTrain().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
		    driver.switchTo().window(currentWindow);
		}
		
		Thread.sleep(2000);
		MaharajaLandPage maharajaLand = new MaharajaLandPage(driver);
		maharajaLand.loginBtn().click();
		Thread.sleep(2000);
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		maharajaLand.username().sendKeys(Username);
		Thread.sleep(2000);

		maharajaLand.password().sendKeys(Password);

		Thread.sleep(1000);

		maharajaLand.signinBtn().click();
		Thread.sleep(5000);
		
		maharajaLand.BookBtn().click();
		Thread.sleep(1500);
		MaharajaBookingPage booking = new MaharajaBookingPage(driver);
		booking.packageDrpdwn().click();
		Thread.sleep(2000);
		booking.packageSelect().click();
		Thread.sleep(1000);
		booking.departureDrpdwn().click();
		Thread.sleep(2000);
		booking.departureDate().click();
		Thread.sleep(1000);
		booking.roomDrpdwn().click();
		Thread.sleep(1000);
		booking.noOfRooms().click();
		Thread.sleep(2000);
		booking.cabinDrpdwn().click();
		Thread.sleep(1000);
		booking.cabinSelect().click();
		Thread.sleep(1000);
		booking.adultDrpdwn().click();
		Thread.sleep(1000);
		booking.adultSelect().click();
		Thread.sleep(1000);
		booking.continueBtn().click();
		Thread.sleep(1000);
		booking.payment().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		booking.proceedBtn().click();
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path, "maharajaBook");
		String firstName=reader.getCellData(1, 1);
		String lastName=reader.getCellData(1, 2);
		String age=reader.getCellData(1, 3);
		String nationality=reader.getCellData(1, 4);
		String passport=reader.getCellData(1, 5);
		String address=reader.getCellData(1, 6);
		
		MaharajaPassengerDetailsPage details = new MaharajaPassengerDetailsPage(driver);
		details.titleDrpdwn().click();
		Thread.sleep(1000);
		
		details.titleSelect().click();
		Thread.sleep(1000);
		
		details.firstName().sendKeys(firstName);
		Thread.sleep(1000);
		
		details.lastName().sendKeys(lastName);
		Thread.sleep(1000);
		
		details.age().sendKeys(age);
		Thread.sleep(1000);
		
		details.nationality().sendKeys(nationality);
		Thread.sleep(1000);
		
		details.stateDrpdwn().click();
		Thread.sleep(1000);
		
		details.stateSelect().click();
		Thread.sleep(1000);
		
		details.passport().sendKeys(passport);
		Thread.sleep(1000);
		
		details.address().sendKeys(address);
		Thread.sleep(1000);
		
		details.referredDrpdwn().click();
		Thread.sleep(1000);
		
		details.referredSelect().click();
		Thread.sleep(1000);
		
		//details.termsBtn().click();
		
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].scrollIntoView()", details.termsBtn());
		Thread.sleep(6000);
		
		details.submitBtn().click();
		Thread.sleep(3000);
		
		
		MaharajaReviewPage review = new MaharajaReviewPage(driver);
		
		String expectedFirstName=review.expectedFirstName().getText();
		Assert.assertTrue(expectedFirstName.contains(firstName));
		reader.setCellData(Path, expectedFirstName, 1, 7);
		
		String expectedLastName=review.expectedLastName().getText();
		Assert.assertTrue(expectedLastName.contains(lastName));
		reader.setCellData(Path, expectedLastName, 1, 8);
		
		String expectedAge=review.expectedAge().getText();
		Assert.assertTrue(expectedAge.contains(age));
		reader.setCellData(Path, expectedAge, 1, 9);
		
		String expectedNationality=review.expectedNationality().getText();
		Assert.assertTrue(expectedNationality.contains(nationality));
		reader.setCellData(Path, expectedNationality, 1, 10);
		
		String expectedPassport=review.expectedPassport().getText();
		Assert.assertTrue(expectedPassport.contains(passport));
		reader.setCellData(Path, expectedPassport, 1, 11);
		
		String expectedAddress=review.expectedAddress().getText();
		Assert.assertTrue(expectedAddress.contains(address));
		reader.setCellData(Path, expectedAddress, 1, 12);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		if(expectedFirstName.contains(firstName) && expectedLastName.contains(lastName) &&
				expectedAge.contains(age) && expectedNationality.contains(nationality) && 
				expectedPassport.contains(passport) && expectedAddress.contains(address) )
		{
			reader1.setCellData(testExecution, "Pass", 6, 2);
		}
		
		else {
			reader1.setCellData(testExecution, "Fail", 6, 2);
		}
		
		//review.submitBtn().click();
		//Thread.sleep(7000);
		
		review.confirmBtn().click();
		Thread.sleep(5000);
		review.paymentBtn().click();
		Thread.sleep(15000);
		
		
		
	}
	
	@AfterTest

	public void tearDown() {
		driver.quit();
	}

}
