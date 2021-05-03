package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaharajaPassengerDetailsPage {
	public WebDriver driver;
	By titleDrpdwn=By.xpath("//mat-select[@id='mat-select-7']");
	By titleSelect=By.xpath("//div[@id='cdk-overlay-5']/div/div/mat-option[2]");
	By firstName=By.xpath("//input[@id='mat-input-0']");
	By lastName=By.xpath("//input[@id='mat-input-1']");
	By age=By.xpath("//input[@id='mat-input-2']");
	By nationality=By.xpath("//input[@id='mat-input-3']");
	By stateDrpdwn=By.xpath("//mat-select[@id='mat-select-9']");
	By stateSelect=By.xpath("//div[@id='cdk-overlay-6']/div/div/mat-option[19]");
	By passport=By.xpath("//input[@id='mat-input-4']");
	By address=By.xpath("//input[@id='mat-input-5']");
	By referredDrpdwn=By.xpath("//mat-select[@id='mat-select-6']");
	By referredSelect=By.xpath("//div[@id='cdk-overlay-7']/div/div/mat-option[6]");
	By termsBtn=By.xpath("//body/app-root[1]/app-passenger-reservation-form[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/label[1]");
	By submitBtn=By.xpath("//div[@class='col-md-12 text-center mt-2 ng-star-inserted']/button[1]");
	
	
	public MaharajaPassengerDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement titleDrpdwn() {
		return driver.findElement(titleDrpdwn);
	}
	public WebElement titleSelect() {
		return driver.findElement(titleSelect);
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
	public WebElement nationality() {
		return driver.findElement(nationality);
	}
	public WebElement stateDrpdwn() {
		return driver.findElement(stateDrpdwn);
	}
	public WebElement stateSelect() {
		return driver.findElement(stateSelect);
	}
	public WebElement passport() {
		return driver.findElement(passport);
	}
	public WebElement address() {
		return driver.findElement(address);
	}
	public WebElement referredDrpdwn() {
		return driver.findElement(referredDrpdwn);
	}
	public WebElement referredSelect() {
		return driver.findElement(referredSelect);
	}
	public WebElement termsBtn() {
		return driver.findElement(termsBtn);
	}
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}
	
	

}
