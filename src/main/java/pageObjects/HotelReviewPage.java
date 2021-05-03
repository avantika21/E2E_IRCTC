package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelReviewPage {
	public WebDriver driver;
	
	By expectedName=By.xpath("//div[@class='form-row Summary-Details']/div/div/strong");
	By expectedMobile=By.xpath("//div[@class='form-row Summary-Details']/div[2]/div/strong");
	By expectedEmail=By.xpath("//div[@class='form-row Summary-Details']/div[3]/div/strong");
	By expectedCheckin=By.xpath("//div[@class='hotel-dtl-right-wrap']/div/div[3]/span");
	
	public HotelReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement expectedName() {
		return driver.findElement(expectedName);
	}
	
	public WebElement expectedMobile() {
		return driver.findElement(expectedMobile);
	}
	
	public WebElement expectedEmail() {
		return driver.findElement(expectedEmail);
	}
	
	public WebElement expectedCheckin() {
		return driver.findElement(expectedCheckin);
	}

}
