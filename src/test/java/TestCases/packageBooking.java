package TestCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.ExcelUtil;
import pageObjects.LandingPage;
import pageObjects.PackageInfoPage;
import pageObjects.PackageListPage;
import pageObjects.PackageLoginPage;
import pageObjects.PackagePassengerDetailsPage;
import pageObjects.PackageReviewPage;
import resources.base;

public class packageBooking extends base{

	String Path="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\packageBooking .xlsx";
	String testExecution="C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\test\\java\\TestData\\testCaseExecution.xlsx";
	
	@BeforeTest

	public void initialize() throws Exception {

		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(testExecution, "execution");

		
		String runMode=reader.getCellData(7, 1);
		if(runMode.equalsIgnoreCase("yes")) {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(runMode.equalsIgnoreCase("no")) {
			reader.setCellData(testExecution, "Skipped", 7, 2);
			throw new SkipException ("Test Case is skipped");
		}
		
		
		//driver = initializeDriver();
		//driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void packageBook() throws Exception {
		
		LandingPage landPage = new LandingPage(driver);
		landPage.alertClick().click();
		Actions action=new Actions(driver);
		action.moveToElement(landPage.holiday()).build().perform();
		Thread.sleep(1000);
		landPage.specialTrains().click();
		Thread.sleep(500);
		landPage.touristTrain().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows){
		    driver.switchTo().window(currentWindow);
		}
		
		PackageListPage packagePage = new PackageListPage(driver);
		packagePage.bookButton().click();
		
		ExcelUtil reader = new ExcelUtil();
		reader.setExcelFile(Path, "packageBook");
		
		PackageInfoPage packageInfo = new PackageInfoPage(driver);
		Thread.sleep(7000);
		
		String tourDate=reader.getCellData(1, 1);
		String boardingStn=reader.getCellData(1, 2);
		String deboardingStn=reader.getCellData(1, 3);
		String numberOfPax=reader.getCellData(1, 4);
		
		Select date = new Select(packageInfo.tourDate());
		date.selectByIndex(1);
		Thread.sleep(1000);
		
		Select boardingStation = new Select(packageInfo.boardingStn());
		boardingStation.selectByValue(boardingStn);
		Thread.sleep(2000);
		
		Select deboardingStation = new Select(packageInfo.deboardingStn());
		deboardingStation.selectByValue(deboardingStn);
		Thread.sleep(2000);
		
		Select noOfpax = new Select(packageInfo.numberOfPax());
		noOfpax.selectByValue(numberOfPax);
		
		packageInfo.continueButton().click();
		
		Thread.sleep(5000);
		
		PackageLoginPage login = new PackageLoginPage(driver);
		
		String Username= prop.getProperty("username");
		String Password=prop.getProperty("password");
		login.Username().sendKeys(Username);
		Thread.sleep(2000);

		login.Password().sendKeys(Password);

		Thread.sleep(1000);

		login.signinBtn().click();
		Thread.sleep(5000);
		
		PackagePassengerDetailsPage PssngrDetails = new PackagePassengerDetailsPage(driver);
		
		String firstName=reader.getCellData(1, 5);
		String lastName=reader.getCellData(1, 6);
		String age=reader.getCellData(1, 7);
		String gender=reader.getCellData(1, 8);
		String nomineeName=reader.getCellData(1, 9);
		String nomineeRelation=reader.getCellData(1, 10);
		String nomineeContact=reader.getCellData(1, 11);
		String address=reader.getCellData(1, 12);
		String state=reader.getCellData(1, 13);
		String IDcardType=reader.getCellData(1, 14);
		String IDcardNumber=reader.getCellData(1, 15);
		
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].scrollIntoView()", PssngrDetails.firstName());

		
		PssngrDetails.firstName().sendKeys(firstName);
		Thread.sleep(1000);
		PssngrDetails.lastName().sendKeys(lastName);
		Thread.sleep(1000);
		PssngrDetails.age().sendKeys(age);
		Thread.sleep(1000);
		
		Select genderP = new Select(PssngrDetails.gender());
		genderP.selectByValue(gender);
		Thread.sleep(1000);
		PssngrDetails.nomineeName().sendKeys(nomineeName);
		Thread.sleep(1000);
		PssngrDetails.nomineeRelation().sendKeys(nomineeRelation);
		Thread.sleep(1000);
		PssngrDetails.nomineeContact().sendKeys(nomineeContact);
		Thread.sleep(1000);
		PssngrDetails.address().clear();
		PssngrDetails.address().sendKeys(address);
		Thread.sleep(1000);
		
		Select State = new Select(PssngrDetails.state());
		State.selectByValue(state);
		Thread.sleep(1000);
		Select idcardType = new Select(PssngrDetails.IDcardType());
		idcardType.selectByVisibleText(IDcardType);
		Thread.sleep(1000);
		PssngrDetails.IDcardNumber().sendKeys(IDcardNumber);
		Thread.sleep(3000);
		PssngrDetails.submitBtn().click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		PackageReviewPage review = new PackageReviewPage(driver);
		
		String expectedName=review.expectedName().getText();
		Assert.assertTrue(expectedName.contains(firstName));
		reader.setCellData(Path, expectedName, 1, 16);
		
		String expectedAge=review.expectedAge().getText();
		Assert.assertTrue(expectedAge.contains(age));
		reader.setCellData(Path, expectedAge, 1, 17);
		
		String expectedGender=review.expectedGender().getText();
		Assert.assertTrue(expectedGender.contains(gender));
		reader.setCellData(Path, expectedGender, 1, 18);
		
		ExcelUtil reader1 = new ExcelUtil();
		reader1.setExcelFile(testExecution, "execution");
		
		if(expectedName.contains(firstName) && expectedAge.contains(age) && expectedGender.contains(gender) ) {
			reader1.setCellData(testExecution, "Pass", 7, 2);
		}
		
		else {
			reader1.setCellData(testExecution, "Fail", 7, 2);
		}
		
		review.agreeBtn().click();
		Thread.sleep(1000);
		review.paymentBtn().click();
		Thread.sleep(15000);	
		
	}
	
	@AfterTest

	public void tearDown() {
		driver.quit();
	}
}
