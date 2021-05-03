package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightLandPage {

	public WebDriver driver;
	By signInbtn=By.xpath("//button[@class='btn btn-sm blue-gradient btn-rounded waves-effect waves-light m-0 px-3 py-0']");
	By username=By.id("loginuserid");
	By password=By.id("pwd");
	By login=By.xpath("//div[@class='text-center mt-0']/button");
	By roundTrip=By.xpath("//label[@for='Round-Trip']");
	By origin=By.id("stationFrom");
	By destination=By.id("stationTo");
	By departureDrpdwn=By.id("Departure-Date");
	By returnDrpdwn=By.id("Return-Date");
	By departureMonth=By.xpath("//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom rdeparturedate']/div/table/tbody/tr/td/span[1]");
	By departureDate=By.xpath("//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom rdeparturedate']/div/table/tbody/tr/td/span[@class='act']");
	By returnMonth=By.xpath("//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom returnDate']/div/table/tbody/tr/td/span[1]");
	By returnDate=By.xpath("//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom returnDate']/div/table/tbody/tr/td/span[@class='act']");
	By searchBtn=By.xpath("//button[contains(text(),'Search')] ");
	
	
	
	public FlightLandPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement signInbtn() {
		return driver.findElement(signInbtn);
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
	
	public WebElement origin() {
		return driver.findElement(origin);
	}
	
	public WebElement destination() {
		return driver.findElement(destination);
	}
	
	public WebElement departureDrpdwn() {
		return driver.findElement(departureDrpdwn);
	}
	
	public WebElement roundTrip() {
		return driver.findElement(roundTrip);
	}
	
	public WebElement returnDrpdwn() {
		return driver.findElement(returnDrpdwn);
	}
	
	public List <WebElement> departureDate() {
		return driver.findElements(departureDate);
	}
	
	public List <WebElement> departureMonth() {
		return driver.findElements(departureMonth);
	}
	
	public List <WebElement> returnMonth() {
		return driver.findElements(returnMonth);
	}
	
	public List <WebElement> returnDate() {
		return driver.findElements(returnDate);
	}
	
	public WebElement searchBtn() {
		return driver.findElement(searchBtn);
	}
}
