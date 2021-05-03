package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By login = By.xpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[1]/a[1]");
	By alert = By.xpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
	By Trains=By.xpath("//li[@class='menu-list header-icon-menu']/a[1]/span/strong[contains(text(),'TRAINS')]");
	By bookTicket=By.xpath("//span[contains(text(),'Book Ticket')]");
	By schedule=By.xpath("//span[contains(text(),'Train Schedule')]");
	By trainInput=By.xpath("//input[@name='trainNumberInput']");
	By trainTrack=By.xpath("//span[contains(text(),'Track Your Train')]");
	By searchButton=By.xpath("//button[@class='btn btn-primary form-control']");
	By newSearch=By.xpath("//button[@id='backToTrainSearchBtn']");
	By trainNum=By.xpath("//input[@id='trainInput']");
	By holiday=By.xpath("//li[@class='menu-list header-icon-menu']/a[contains(text(),'HOLIDAYS')] ");
	By specialTrains=By.xpath("//span[contains(text(),'Special Trains')] ");
	By touristTrain=By.xpath("//app-header/div[2]/div[2]/div[2]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/ul[1]/li[1]/a");
	By maharajaTrain=By.xpath("//app-header/div[2]/div[2]/div[2]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/ul[1]/li[2]/a");
	By stays=By.xpath("//span[contains(text(),'Stays')] ");
	By irctcHotel=By.xpath("//app-header/div[2]/div[2]/div[2]/nav[1]/ul[1]/li[4]/ul[1]/li[3]/ul[1]/li[1]/a");
	By flightBtn=By.xpath("//ul[@class='menu']/li[5]/a");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}



	public WebElement loginClick() {
		return driver.findElement(login);
	}
	
	public WebElement alertClick() {
		return driver.findElement(alert);
	}
	
	public WebElement Trains() {
		return driver.findElement(Trains);
	}
	
	public WebElement bookTicket() {
		return driver.findElement(bookTicket);
	}
	
	public WebElement schedule() {
		return driver.findElement(schedule);
	}
	
	public WebElement trainInput() {
		return driver.findElement(trainInput);
	}
	
	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}
	
	public WebElement trainTrack() {
		return driver.findElement(trainTrack);
	}
	
	public WebElement newSearch() {
		return driver.findElement(newSearch);
	}
	
	public WebElement trainNum() {
		return driver.findElement(trainNum);
	}

	public WebElement holiday() {
		return driver.findElement(holiday);
	}

	public WebElement specialTrains() {
		return driver.findElement(specialTrains);
	}
	
	public WebElement touristTrain() {
		return driver.findElement(touristTrain);
	}
	
	public WebElement maharajaTrain() {
		return driver.findElement(maharajaTrain);
	}
	
	public WebElement stays() {
		return driver.findElement(stays);
	}
	
	public WebElement irctcHotel() {
		return driver.findElement(irctcHotel);
	}
	
	public WebElement flightBtn() {
		return driver.findElement(flightBtn);
	}
}
