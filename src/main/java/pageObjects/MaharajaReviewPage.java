package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaharajaReviewPage {
	public WebDriver driver;
	By expectedFirstName=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[2]/div/span");
	By expectedLastName=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[3]/div/span");
	By expectedAge=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[4]/div/span");
	By expectedNationality=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[5]/div/span");
	By expectedPassport=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[7]/div/span");
	By expectedAddress=By.xpath("//div[@class='col-12 ng-star-inserted']/div/div[8]/div/span");
	By submitBtn=By.xpath("//div[@class='col-md-12 text-center mt-2 ng-star-inserted']/button[1]");
	By confirmBtn=By.xpath("//div[@class='col-md-12 text-center mb-2']/button");
	By paymentBtn=By.xpath("//div[@class='text-center col-12 my-2']/button");
	
	public MaharajaReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement expectedFirstName() {
		return driver.findElement(expectedFirstName);
	}
	public WebElement expectedLastName() {
		return driver.findElement(expectedLastName);
	}
	public WebElement expectedAge() {
		return driver.findElement(expectedAge);
	}
	public WebElement expectedNationality() {
		return driver.findElement(expectedNationality);
	}
	public WebElement expectedPassport() {
		return driver.findElement(expectedPassport);
	}
	public WebElement expectedAddress() {
		return driver.findElement(expectedAddress);
	}
	public WebElement submitBtn() {
		return driver.findElement(submitBtn);
	}
	public WebElement confirmBtn() {
		return driver.findElement(confirmBtn);
	}
	public WebElement paymentBtn() {
		return driver.findElement(paymentBtn);
	}
}
