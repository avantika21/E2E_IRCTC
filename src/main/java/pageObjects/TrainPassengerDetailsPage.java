package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainPassengerDetailsPage {

	public WebDriver driver;
	
	By passengerName=By.xpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-passenger-input[1]/div[5]/form[1]/div[1]/div[1]/div[4]/p-panel[1]/div[1]/div[2]/div[1]/div[1]/div[2]/app-passenger[1]/div[1]/div[1]/div[1]/p-autocomplete[1]/span[1]/input[1]");
	By passengerAge=By.xpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-passenger-input[1]/div[5]/form[1]/div[1]/div[1]/div[4]/p-panel[1]/div[1]/div[2]/div[1]/div[1]/div[2]/app-passenger[1]/div[1]/div[1]/div[2]/input[1]");
	By passengerGender=By.xpath("//select[@class='form-control ng-untouched ng-pristine ng-invalid ng-star-inserted']");
	By passengerMobile=By.xpath("//input[@id='mobileNumber']");
	By address1=By.xpath("//input[@id='aaa1']");
	By address2=By.xpath("//input[@id='aaa2']");
	By pincode=By.xpath("//input[@id='aaa4']");
	By postOffice=By.xpath("//select[@id='address-postOffice']");
	By state=By.xpath("//input[@id='address-State']");
	By travelInsurance=By.xpath("//p-radiobutton[@id='travelInsuranceOptedYes']");
	By continueButton=By.xpath("//button[@class='train_Search btnDefault']");
	
	public TrainPassengerDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement passengerName() {
		 
		return driver.findElement(passengerName);
	}
	
	public WebElement passengerAge() {
		 
		return driver.findElement(passengerAge);
	}
	
	public WebElement passengerGender() {
		 
		return driver.findElement(passengerGender);
	}
	
	public WebElement passengerMobile() {
		 
		return driver.findElement(passengerMobile);
	}
	
	public WebElement address1() {
		 
		return driver.findElement(address1);
	}
	
	public WebElement address2() {
		 
		return driver.findElement(address2);
	}
	
	public WebElement pincode() {
		 
		return driver.findElement(pincode);
	}
	
	public WebElement postOffice() {
		 
		return driver.findElement(postOffice);
	}
	
	public WebElement state() {
		 
		return driver.findElement(state);
	}
	
	public WebElement continueButton() {
		 
		return driver.findElement(continueButton);
	}
	
	public List<WebElement> travelInsurance() {
		 
		return driver.findElements(travelInsurance);
	}
}                                   
