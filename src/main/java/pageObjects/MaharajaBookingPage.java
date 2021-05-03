package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaharajaBookingPage {
	public WebDriver driver;
	By packageDrpdwn=By.xpath("//mat-select[@id='mat-select-0']");
	By packageSelect=By.xpath("//mat-option[@id='mat-option-9']");
	By departureDrpdwn=By.xpath("//mat-select[@id='mat-select-1']");
	By departureDate=By.xpath("//div[@id='cdk-overlay-1']/div/div/mat-option[2]");
	By roomDrpdwn=By.xpath("//mat-select[@id='mat-select-2']");
	By noOfRooms=By.xpath("//div[@id='cdk-overlay-2']/div/div/mat-option[2]");
	By cabinDrpdwn=By.xpath("//mat-select[@id='mat-select-3']");
	By cabinSelect=By.xpath("//div[@id='cdk-overlay-3']/div/div/mat-option[2]");
	By adultDrpdwn=By.xpath("//mat-select[@id='mat-select-4']");
	By adultSelect=By.xpath("//div[@id='cdk-overlay-4']/div/div/mat-option[2]");
	By continueBtn=By.xpath("//div[@class='col-md-12 text-center']/button");
	By payment=By.xpath("//div[@class='col-md-12 text-center mt-2']/button");
	By proceedBtn=By.xpath("//div[@class='table-responsive gems_table']/table/tbody/tr[7]/td/button");
	public MaharajaBookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement packageDrpdwn() {
		return driver.findElement(packageDrpdwn);
	}
	
	public WebElement packageSelect() {
		return driver.findElement(packageSelect);
	}

	public WebElement departureDrpdwn() {
		return driver.findElement(departureDrpdwn);
	}
	
	public WebElement roomDrpdwn() {
		return driver.findElement(roomDrpdwn);
	}
	
	public WebElement departureDate() {
		return driver.findElement(departureDate);
	}
	
	public WebElement cabinDrpdwn() {
		return driver.findElement(cabinDrpdwn);
	}
	public WebElement cabinSelect() {
		return driver.findElement(cabinSelect);
	}
	public WebElement adultDrpdwn() {
		return driver.findElement(adultDrpdwn);
	}
	public WebElement adultSelect() {
		return driver.findElement(adultSelect);
	}
	public WebElement noOfRooms() {
		return driver.findElement(noOfRooms);
	}
	public WebElement payment() {
		return driver.findElement(payment);
	}
	
	public WebElement continueBtn() {
		return driver.findElement(continueBtn);
	}
	
	public WebElement proceedBtn() {
		return driver.findElement(proceedBtn);
	}
}
