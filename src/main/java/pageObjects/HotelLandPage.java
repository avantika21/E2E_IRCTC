package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelLandPage {
	public WebDriver driver;
	By loginBtn=By.xpath("//a[@class='right-header']");
	By username=By.xpath("//input[@id='modalLRInput10']");
	By password=By.xpath("//input[@id='modalLRInput11']");
	By login=By.xpath("//div[@class='text-center mt-2']/button");
	By destinationCity=By.xpath("//searchbox/input");
	By destinationSelect=By.xpath("//div[@class='autofill-custom-wrap']/ul/li/a");
	By calenderDrpdwn=By.xpath("//input[@name='dt12']");
	By nextMonth=By.xpath("//div[@class='owl-dt-calendar-control']/button[2]");
	By checkInDate=By.xpath("//tbody/tr/td/span");
	By findHotel=By.xpath("//div[@class='col-12 col-sm-12 col-md-12 col-lg-2 form-btn-find']/button");
	
	public HotelLandPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement nextMonth() {
		return driver.findElement(nextMonth);
	}
	
	public WebElement findHotel() {
		return driver.findElement(findHotel);
	}
	
	public List<WebElement> checkInDate() {
		return driver.findElements(checkInDate);
	}
	public WebElement destinationSelect() {
		return driver.findElement(destinationSelect);
	}
	
	public WebElement calenderDrpdwn() {
		return driver.findElement(calenderDrpdwn);
	}
	
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement login() {
		return driver.findElement(login);
	}
	public WebElement destinationCity() {
		return driver.findElement(destinationCity);
	}
}
