package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightPassengerDetails {

	public WebDriver driver;
	By dob = By.id("create-invoice-invoice-date");
	By dobYear = By.xpath(
			"//select[@class='browser-default custom-select form-control btn-rounded font-14 ng-untouched ng-pristine ng-valid']");
	By dobMonth = By.xpath("//th[@class='date-next py-1']/span[1]");
	By dobDate = By.xpath("//table[@class='date-table']/tbody/tr/td/span");
	By title = By.xpath(
			"//select[@class='browser-default custom-select form-control btn-rounded font-14 ng-untouched ng-pristine ng-invalid']");
	By firstName = By.xpath("//input[@placeholder='First & Middle Name *']");
	By lastName = By.xpath("//input[@placeholder='Last Name *']");
	By email = By.xpath("//input[@placeholder='Email Id *']");
	By mobileNo = By.xpath("//input[@placeholder='Mobile Number *']");
	By state = By.id("State");
	By mobile = By.id("Mobile");
	By terms = By.xpath("//label[@class='form-check-label font-14 error']");
	By continueBtn = By.xpath("//div[@class='col-12 text-center my-2']/button[2]");

	public FlightPassengerDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public WebElement dob() {
		return driver.findElement(dob);
	}

	public WebElement dobYear() {
		return driver.findElement(dobYear);
	}

	public WebElement dobMonth() {
		return driver.findElement(dobMonth);
	}

	public List<WebElement> dobDate() {
		return driver.findElements(dobDate);
	}

	public WebElement title() {
		return driver.findElement(title);
	}

	public WebElement firstName() {
		return driver.findElement(firstName);
	}

	public WebElement lastName() {
		return driver.findElement(lastName);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement mobileNo() {
		return driver.findElement(mobileNo);
	}

	public WebElement state() {
		return driver.findElement(state);
	}

	public WebElement mobile() {
		return driver.findElement(mobile);
	}

	public WebElement terms() {
		return driver.findElement(terms);
	}

	public WebElement continueBtn() {
		return driver.findElement(continueBtn);
	}

}
