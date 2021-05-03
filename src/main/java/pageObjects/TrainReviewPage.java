package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainReviewPage {
	
	public WebDriver driver;
	By continueButton=By.xpath("//*[@id=\"review\"]/div[1]/div[9]/div/button[2]");
	By captcha=By.xpath("//input[@id='nlpAnswer']");
	//By expectedOrigin=By.xpath("//strong[contains(text(),'13:05 | UDAIPUR CITY')]");
	By expectedOrigin=By.xpath("//app-train-header/div[3]/div/div[1]/span[1]/strong[1]");
	//By expectedDestination=By.xpath("//strong[contains(text(),'21:50 | JAIPUR')]");
	By expectedDestination=By.xpath("//app-train-header/div[3]/div/div[2]/span[2]/strong[1]");
	By expectedClass=By.xpath("//app-train-header[1]/div[5]/span[1]/strong[1]/span[2]");
	By expectedQuota=By.xpath("//app-train-header[1]/div[5]/span[1]/strong[1]/span[3]");
	By expectedDate=By.xpath("//app-train-header/div[3]/div[1]/div[2]/span[2]/span[1]");
	By expectedName=By.xpath("//app-psgn-detail/p-panel[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/strong[1]");
	By expectedAge=By.xpath("//app-psgn-detail/p-panel/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/span[2]");
	By expectedGender=By.xpath("//app-psgn-detail/p-panel/div/div[2]/div/div/div/div[2]/span[3]");
	By cancellation=By.xpath("//a[contains(text(),'View Cancellation Policy')]");
	
	public TrainReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
	
	public WebElement expectedOrigin() {
		return driver.findElement(expectedOrigin);
	}
	
	public WebElement expectedDestination() {
		return driver.findElement(expectedDestination);
	}
	
	public WebElement expectedClass() {
		return driver.findElement(expectedClass);
	}
	
	public WebElement expectedQuota() {
		return driver.findElement(expectedQuota);
	}
	
	public WebElement expectedName() {
		return driver.findElement(expectedName);
	}
	
	public WebElement expectedAge() {
		return driver.findElement(expectedAge);
	}
	
	public WebElement expectedGender() {
		return driver.findElement(expectedGender);
	}
	
	public WebElement cancellation() {
		return driver.findElement(cancellation);
	}
	
	public WebElement expectedDate() {
		return driver.findElement(expectedDate);
	}

}
