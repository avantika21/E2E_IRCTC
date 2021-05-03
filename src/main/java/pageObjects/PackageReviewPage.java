package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackageReviewPage {
	public WebDriver driver;
	By expectedName=By.xpath("//div[@class='table-responsive text-nowrap custom-table col-12']/table/tbody/tr/td[2]");
	By expectedAge=By.xpath("//div[@class='table-responsive text-nowrap custom-table col-12']/table/tbody/tr/td[3]");
	By expectedGender=By.xpath("//div[@class='table-responsive text-nowrap custom-table col-12']/table/tbody/tr/td[4]");
	By agreeBtn=By.xpath("//span[contains(text(), 'I Agree')]");
	By paymentBtn=By.xpath("//div[@class='d-block text-center my-2']/button[2]");
	
	public PackageReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
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
	public WebElement agreeBtn() {
		return driver.findElement(agreeBtn);
	}
	
	public WebElement paymentBtn() {
		return driver.findElement(paymentBtn);
	}
}
