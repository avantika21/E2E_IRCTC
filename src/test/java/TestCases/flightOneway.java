package TestCases;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.FlightLandPage;
import pageObjects.FlightListPage;
import pageObjects.FlightPassengerDetails;
import pageObjects.FlightReviewPage;
import pageObjects.LandingPage;
import resources.base;

public class flightOneway extends base{
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\flightBooking.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";

	@BeforeTest
	
	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(12, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 12, 2);
			throw new SkipException ("Test Case is skipped");
		}

	}
	
	@Test
	
	public void FlightOneway() throws Exception {
		
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		landPage.flightBtn().click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
		    driver.switchTo().window(currentWindow);
		}
		
		Thread.sleep(2000);
		
		FlightLandPage flightLand = new FlightLandPage(driver);
		Thread.sleep(5000);
		flightLand.signInbtn().click();
		Thread.sleep(5000);
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		
		flightLand.username().sendKeys(Username);
		Thread.sleep(1000);
		flightLand.password().sendKeys(Password);
		Thread.sleep(1000);
		flightLand.login().click();
		Thread.sleep(3000);
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"OneWay");
		
		String origin=reader.getCellData(1, 1);
		String destination=reader.getCellData(1, 2);
		String departureMonth=reader.getCellData(1, 3);
		String departureDate=reader.getCellData(1, 4);
		

		flightLand.origin().sendKeys(origin);
		Thread.sleep(1000);
		flightLand.origin().sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(2000);
	
		flightLand.destination().sendKeys(destination);
		Thread.sleep(2000);
		flightLand.destination().sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(1000);
		flightLand.departureDrpdwn().click();
		Thread.sleep(2000);
		
		List <WebElement> departure =flightLand.departureMonth();
		//System.out.println(departure.size());
		for(int i=0; i<departure.size(); i++) {
			String month=departure.get(i).getText();
			
			//System.out.println(month);
			if(month.equalsIgnoreCase(departureMonth)) {
				departure.get(i).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		List <WebElement> departuredate =flightLand.departureDate();
		System.out.println(departuredate.size());
		for(int i=0; i<departuredate.size(); i++) {
			String date=departuredate.get(i).getText();
			
			System.out.println(date);
			if(date.contains(departureDate)) {
				departuredate.get(i).click();
				break;
			}
		}
		
		flightLand.searchBtn().click();
		Thread.sleep(4000);
		
		FlightListPage list=new FlightListPage(driver);
		list.bookBtn().click();
		Thread.sleep(1000);
		list.gstNo().click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		list.addInfo().click();
		Thread.sleep(5000);
		
		FlightPassengerDetails details=new FlightPassengerDetails(driver);
		
		String title=reader.getCellData(1, 5);
		String firstName=reader.getCellData(1, 6);
		String lastName=reader.getCellData(1, 7);
		String dobDate=reader.getCellData(1, 8);
		String dobMonth=reader.getCellData(1, 9);
		String dobYear=reader.getCellData(1, 10);
		String email=reader.getCellData(1, 11);
		String mobileNo=reader.getCellData(1, 12);
		String state=reader.getCellData(1, 13);
		
		
		Select Title = new Select(details.title());
		Title.selectByVisibleText(title);
		Thread.sleep(1000);
		
		details.firstName().sendKeys(firstName);
		Thread.sleep(1000);
		details.lastName().sendKeys(lastName);
		Thread.sleep(1000);
		
		details.dob().click();
		Thread.sleep(1000);
		Select year=new Select(details.dobYear());
		year.selectByValue(dobYear);
		Thread.sleep(1000);
		for(int i=0; i<6; i++) {
			details.dobMonth().click();
			Thread.sleep(1000);
		}
		
		List <WebElement> dobdate=details.dobDate();
		for(int i=0; i<dobdate.size(); i++) {
			String date=dobdate.get(i).getText();
			if(date.contains(dobDate)) {
				dobdate.get(i).click();
				break;
			}
		}
		
		Thread.sleep(1000);
		
		details.email().sendKeys(email);
		Thread.sleep(1000);
		details.mobileNo().sendKeys(mobileNo);
		Thread.sleep(1000);
		
		Select State=new Select(details.state());
		State.selectByValue(state);
		Thread.sleep(1000);
		details.mobile().sendKeys(mobileNo);
		Thread.sleep(1000);
		details.terms().click();
		Thread.sleep(1000);
		details.continueBtn().click();
        Thread.sleep(5000);
		
		FlightReviewPage review=new FlightReviewPage(driver);
		
		List <WebElement> Cityleft=review.CityLeftR();
		String departureCity=Cityleft.get(0).getText();
		List <WebElement> CityRight=review.CityRightR();
		String arrivalCity=CityRight.get(0).getText();
		List <WebElement> date=review.date();
		String dateDepart=date.get(0).getText();
		String returnDate=review.returnDate().getText();
		reader.setCellData(Path,departureCity , 1, 14);
		reader.setCellData(Path,arrivalCity , 1, 15);
		reader.setCellData(Path,dateDepart , 1, 16);
		

		String PssngrName=review.name().getText();
		reader.setCellData(Path,PssngrName , 1, 17);
		String birthDate=review.dob().getText();
		reader.setCellData(Path,birthDate , 1, 18);
		String PssngrGender=review.gender().getText();
		reader.setCellData(Path,PssngrGender , 1, 19);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		
		reader1.setCellData(testExecution, "Pass", 12, 2);
		Thread.sleep(2000);
		review.terms().click();
		Thread.sleep(2000);
		review.continueBtn().click();
		Thread.sleep(15000);
		
	}
	
	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
