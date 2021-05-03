package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PackageInfoPage {
	
	public WebDriver driver;
	By tourDate=By.xpath("//select[@name='country']");
	By boardingStn=By.xpath("//select[@name='boardst']");
	By deboardingStn=By.xpath("//select[@name='deBoardst']");
	By numberOfPax=By.xpath("//select[@name='noOfPax']");
	By continueButton=By.xpath("//div[@class='d-block text-center my-2']/button");
	
	public PackageInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement tourDate() {
		return driver.findElement(tourDate);
	}
	
	public WebElement boardingStn() {
		return driver.findElement(boardingStn);
	}
	
	public WebElement deboardingStn() {
		return driver.findElement(deboardingStn);
	}
	
	public WebElement numberOfPax() {
		return driver.findElement(numberOfPax);
	}
	
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
 
}
