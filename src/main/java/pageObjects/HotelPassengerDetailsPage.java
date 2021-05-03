package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelPassengerDetailsPage {
	public WebDriver driver;
	By title=By.xpath("//select[@name='title']");
	By firstName=By.xpath("//input[@name='firstName']");
	By lastName=By.xpath("//input[@name='lastName']");
	By state=By.xpath("//select[@name='state']");
	By mobileNumber=By.xpath("//input[@name='mobileNo']");
	By email=By.xpath("//input[@name='email']");
	By goBtn=By.xpath("//div[@class='col-md-12 text-center my-1']/button[2]");
	By agree=By.xpath("//label[@class='form-check-label']");
	By paymentBtn=By.xpath("//div[@class='col-md-12 text-center']/button[2]");
	//By firstName=By.xpath("");
	
	public HotelPassengerDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement agree() {
		return driver.findElement(agree);
	}
	public WebElement paymentBtn() {
		return driver.findElement(paymentBtn);
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
	
	public WebElement state() {
		return driver.findElement(state);
	}
	
	public WebElement mobileNumber() {
		return driver.findElement(mobileNumber);
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement goBtn() {
		return driver.findElement(goBtn);
	}
}
