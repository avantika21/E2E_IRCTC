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

public class flightRoundtrip extends base{
	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\flightBooking.xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";

	@BeforeTest
	
	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(13, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 13, 2);
			throw new SkipException ("Test Case is skipped");
		}

	}
	
	@Test
	
	public void FlightRoundtrip() throws Exception {
		
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
		
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path,"RoundTrip");
		
		String origin=reader.getCellData(1, 1);
		String destination=reader.getCellData(1, 2);
		String departureMonth=reader.getCellData(1, 3);
		String departureDate=reader.getCellData(1, 4);
		String returnMonth=reader.getCellData(1, 5);
		String returnDate=reader.getCellData(1, 6);
		
		flightLand.roundTrip().click();
		Thread.sleep(1000);
		
	
		flightLand.origin().sendKeys(origin);
		Thread.sleep(6000);
		flightLand.origin().sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(2000);

		flightLand.destination().sendKeys(destination);
		Thread.sleep(6000);
		flightLand.destination().sendKeys(Keys.DOWN, Keys.RETURN);
		Thread.sleep(1000);
		flightLand.departureDrpdwn().click();
		Thread.sleep(2000);
		
		List <WebElement> departuremonth =flightLand.departureMonth();
		//System.out.println(departuremonth.size());
		for(int i=0; i<departuremonth.size(); i++) {
			String month=departuremonth.get(i).getText();
			
			//System.out.println(month);
			if(month.equalsIgnoreCase(departureMonth)) {
				departuremonth.get(i).click();
				break;
			}
		}
		
		Thread.sleep(3000);
		
		List <WebElement> departuredate =flightLand.departureDate();
		//System.out.println(departuredate.size());
		for(int i=0; i<departuredate.size(); i++) {
			String date=departuredate.get(i).getText();
			
			//System.out.println(date);
			if(date.contains(departureDate)) {
				departuredate.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		flightLand.returnDrpdwn().click();
		Thread.sleep(1000);
		
		List <WebElement> returnmonth =flightLand.returnMonth();
		//System.out.println(returnmonth.size());
		for(int i=0; i<returnmonth.size(); i++) {
			String month=returnmonth.get(i).getText();
			
			//System.out.println(month);
			if(month.equalsIgnoreCase(returnMonth)) {
				returnmonth.get(i).click();
				break;
			}
		}
		
		List <WebElement> returndate =flightLand.returnDate();
		//System.out.println(returndate.size());
		for(int i=0; i<returndate.size(); i++) {
			String date=returndate.get(i).getText();
			
			//System.out.println(date);
			if(date.contains(returnDate)) {
				returndate.get(i).click();
				break;
			}
		}
		

		flightLand.searchBtn().click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		FlightListPage list=new FlightListPage(driver);
		list.bookBtnR().click();
		Thread.sleep(10000);
		
		list.normalFare().click();
		Thread.sleep(2000);
		list.gstNo().click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		
		
		list.addInfo().click();
        Thread.sleep(5000);
		
		FlightPassengerDetails details=new FlightPassengerDetails(driver);
		
		String title=reader.getCellData(1, 7);
		String firstName=reader.getCellData(1, 8);
		String lastName=reader.getCellData(1, 9);
		String dobDate=reader.getCellData(1, 10);
		String dobMonth=reader.getCellData(1, 11);
		String dobYear=reader.getCellData(1, 12);
		String email=reader.getCellData(1, 13);
		String mobileNo=reader.getCellData(1, 14);
		String state=reader.getCellData(1, 15);
		
		
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
		String returnDeparture=Cityleft.get(2).getText();
		String stopAt=Cityleft.get(3).getText();
		reader.setCellData(Path,departureCity , 1, 16);
		reader.setCellData(Path,returnDeparture , 1, 19);
		reader.setCellData(Path,stopAt , 1, 21);
		
		List <WebElement> CityRight=review.CityRightR();
		String arrivalCity=CityRight.get(1).getText();
		String returnArrival=CityRight.get(3).getText();
		reader.setCellData(Path,arrivalCity , 1, 17);
		reader.setCellData(Path,returnArrival , 1, 20);
		
		List <WebElement> date=review.date();
		String dateDepart=date.get(0).getText();
		String returnDepart=date.get(2).getText();
		reader.setCellData(Path,dateDepart , 1, 18);
		reader.setCellData(Path,returnDepart , 1, 22);
		
		String PssngrName=review.name().getText();
		reader.setCellData(Path,PssngrName , 1, 23);
		String birthDate=review.dob().getText();
		reader.setCellData(Path,birthDate , 1, 24);
		String PssngrGender=review.gender().getText();
		reader.setCellData(Path,PssngrGender , 1, 25);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		
			reader1.setCellData(testExecution, "Pass", 13, 2);
		
		
		Thread.sleep(2000);
		review.terms().click();
		Thread.sleep(2000);
		review.continueBtn().click();
		Thread.sleep(35000);
		
	}
	
	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
