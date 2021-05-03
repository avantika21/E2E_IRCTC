package TestCases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.HotelLandPage;
import pageObjects.HotelListPage;
import pageObjects.HotelPassengerDetailsPage;
import pageObjects.HotelReviewPage;
import pageObjects.LandingPage;
import resources.base;

public class hotelBooking extends base{

	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\hotelBooking.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";
	@BeforeTest

	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(3, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 3, 2);
			throw new SkipException ("Test Case is skipped");
		}
		
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void hotelBook() throws Exception {
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		Actions action=new Actions(driver);
		action.moveToElement(landPage.holiday()).build().perform();
		Thread.sleep(1000);
		
		landPage.stays().click();
		Thread.sleep(1000);
		landPage.irctcHotel().click();
        
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
		    driver.switchTo().window(currentWindow);
		}
		
		HotelLandPage hotelLand=new HotelLandPage(driver);
		Thread.sleep(8000);
		hotelLand.loginBtn().click();
		Thread.sleep(5000);
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		hotelLand.username().sendKeys(Username);
		Thread.sleep(2000);

		hotelLand.password().sendKeys(Password);

		Thread.sleep(1000);

		hotelLand.login().click();
		Thread.sleep(5000);
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"hotelBook");
		String destinationCity=reader.getCellData(1, 1);
		String checkInDate=reader.getCellData(1, 2);
		
		
		hotelLand.destinationCity().sendKeys(destinationCity);
		Thread.sleep(2000);
		hotelLand.destinationSelect().click();
		Thread.sleep(1000);
		hotelLand.calenderDrpdwn().click();
		Thread.sleep(2000);
		//String checkinDate="30";
		hotelLand.nextMonth().click();
		Thread.sleep(1000);
		List<WebElement> checkin=hotelLand.checkInDate();
		//System.out.println(checkin.size());
		for (int i = 0; i < checkin.size(); i++) {

			String dateValue = checkin.get(i).getText();
			//System.out.println(dateValue);

			if (dateValue.equals(checkInDate)) {
				checkin.get(i).click();
				break;
			}

		}
		Thread.sleep(1000);
		hotelLand.findHotel().click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HotelListPage book=new HotelListPage(driver);
		Thread.sleep(2000);
		book.Book().click();
		Thread.sleep(2000);
		book.continueBook().click();
		
		Thread.sleep(3000);
		HotelPassengerDetailsPage details=new HotelPassengerDetailsPage(driver);
		
		String title=reader.getCellData(1, 3);
		String firstName=reader.getCellData(1, 4);
		String lastName=reader.getCellData(1, 5);
		String State=reader.getCellData(1, 6);
		String mobileNum=reader.getCellData(1, 7);
		String EmailID=reader.getCellData(1, 8);
		
		
		Select Title = new Select(details.title());
		Title.selectByVisibleText(title);
		Thread.sleep(1000);
		details.firstName().sendKeys(firstName);
		Thread.sleep(1000);
		
		details.lastName().sendKeys(lastName);
		Thread.sleep(1000);
		
		Select state=new Select(details.state());
		state.selectByVisibleText(State);
		Thread.sleep(2000);
		
		//details.mobileNumber().clear();
		//details.mobileNumber().sendKeys(mobileNum);
		
		//Thread.sleep(1000);
		//details.email().clear();
		//details.email().sendKeys(EmailID);
		//Thread.sleep(1000);
		details.goBtn().click();
		Thread.sleep(4000);
		
		HotelReviewPage review=new HotelReviewPage(driver);
		String expectedName=review.expectedName().getText();
		reader.setCellData(Path, expectedName, 1, 9);
		
		String expectedMobile=review.expectedMobile().getText();
		reader.setCellData(Path, expectedMobile, 1, 10);
		
		String expectedEmail=review.expectedEmail().getText();
		reader.setCellData(Path, expectedEmail, 1, 11);
		
		String expectedCheckin=review.expectedCheckin().getText();
		reader.setCellData(Path, expectedCheckin, 1, 12);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		if(expectedName.contains(firstName) && expectedMobile.contains(mobileNum) && expectedEmail.contains(EmailID) 
				&& expectedCheckin.contains(checkInDate)) {
			reader1.setCellData(testExecution, "Pass", 3, 2);
		}
		else {
			reader1.setCellData(testExecution, "Fail", 3, 2);
		}
		
		details.agree().click();
		Thread.sleep(1000);
		details.paymentBtn().click();
		Thread.sleep(13000);
	 
		

	}
	
	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}