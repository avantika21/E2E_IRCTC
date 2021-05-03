package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightReviewPage {

	public WebDriver driver;
	By CityLeftR=By.xpath("//div[@class='card p-2']/div/div/div/div[2]/span[2]");
	By CityRightR=By.xpath("//div[@class='flight-details-container-top-in flight-det-cont-4']/span[2]");
	By date=By.xpath("//div[@class='flight-details-container-top-in flight-det-cont-2']/span[3]");
	By name=By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]");
	By dob=By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[4]");
	By gender=By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[5]");
	By terms=By.xpath("//label[@class='form-check-label font-14']");
	By continueBtn=By.xpath("//div[@class='col-12 text-center my-2']/button[2]");
	By returnDate=By.xpath("//div[@class='flight-details-container-top-in flight-det-cont-4']/span[3]");
	
	public FlightReviewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public List <WebElement> CityLeftR() {
		return driver.findElements(CityLeftR);
	}
	
	public List <WebElement> CityRightR() {
		return driver.findElements(CityRightR);
	}
	
	public List <WebElement> date() {
		return driver.findElements(date);
	}
	
	public WebElement name() {
		return driver.findElement(name);
	}
	
	public WebElement dob() {
		return driver.findElement(dob);
	}
	
	public WebElement gender() {
		return driver.findElement(gender);
	}
	
	public WebElement terms() {
		return driver.findElement(terms);
	}
	
	public WebElement continueBtn() {
		return driver.findElement(continueBtn);
	}
	
	public WebElement returnDate() {
		return driver.findElement(returnDate);
	}
	
}
