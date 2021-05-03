package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackagePassengerDetailsPage {

	public WebDriver driver;
	By firstName=By.xpath("//input[@name='item.firstName']");
	By lastName=By.xpath("//input[@name='item.lastName']");
	By age=By.xpath("//input[@placeholder='Age']");
	By gender=By.xpath("//select[@name='item.gender']");
	By nomineeName=By.xpath("//input[@name='nomineeName']");
	By nomineeRelation=By.xpath("//input[@name='RelationwithPassenger']");
	By nomineeContact=By.xpath("//input[@name='contactNo']");
	By address=By.xpath("//input[@name='address']");
	By state=By.xpath("//select[@name='state']");
	By IDcardType=By.xpath("//select[@name='idcardType']");
	By IDcardNumber=By.xpath("//input[@name='idcardno']");
	By submitBtn=By.xpath("//button[contains(text(),'Submit')]");
	
	public PackagePassengerDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement age() {
		return driver.findElement(age);
	}
	
	public WebElement gender() {
		return driver.findElement(gender);
	}
	
	public WebElement nomineeName() {
		return driver.findElement(nomineeName);
	}
	
	public WebElement nomineeRelation() {
		return driver.findElement(nomineeRelation);
	}
	
	public WebElement nomineeContact() {
		return driver.findElement(nomineeContact);
	}
	
	public WebElement address() {
		return driver.findElement(address);
	}
	
	public WebElement state() {
		return driver.findElement(state);
	}
	
	public WebElement IDcardType() {
		return driver.findElement(IDcardType);
	}
	
	public WebElement IDcardNumber() {
		return driver.findElement(IDcardNumber);
	}
	
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}
	
	
}
