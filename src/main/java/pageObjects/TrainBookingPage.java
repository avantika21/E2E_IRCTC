package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainBookingPage {

	public WebDriver driver;
	
	By origin=By.xpath("//*[@id=\"origin\"]/span/input");
	By originDropdown = By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[2]/div[1]/app-jp-input/div/form/div[2]/div[1]/div[1]/p-autocomplete/span/div/ul");
	By bookWithoutLoginOrigin=By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[2]/div[1]/div[1]/p-autocomplete/span/div/ul");
	By destination= By.xpath("//*[@id=\"destination\"]/span/input");
	By bookWithoutLoginDest=By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[1]/div[1]/app-jp-input/div/form/div[2]/div[1]/div[2]/p-autocomplete/span/div/ul");
	By destinationDropdown =By.xpath("/html/body/app-root/app-home/div[3]/div/app-main-page/div/div/div[1]/div[2]/div[1]/app-jp-input/div/form/div[2]/div[1]/div[2]/p-autocomplete/span/div/ul");
	By quota=By.xpath("//*[@id=\"journeyQuota\"]");
	//By quotaDropdown=By.xpath("/html[1]/body[1]/app-root[1]/app-home[1]/div[3]/div[1]/app-main-page[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-jp-input[1]/div[1]/form[1]/div[3]/div[1]/div[1]/p-dropdown[1]/div[1]/div[4]/div[1]/ul[1]");
	
	//By quotaDropdown=By.xpath("//ul[@class='ui-dropdown-items ui-dropdown-list ui-widget-content ui-widget ui-corner-all ui-helper-reset ng-tns-c66-366']/p-dropdownitem[@class='ng-tns-c66-366 ng-star-inserted']/li");
	By quotaDropdown=By.xpath("//p-dropdown[@id='journeyQuota']/div/div[4]/div/ul");
	By calender=By.xpath("//p-calendar[@id='jDate']");
	
	By dateSelect=By.xpath("//tbody/tr/td/a");
	
	By exchange=By.xpath("//a[@class='col-xs-push-11 col-sm-push-6 swap']/i[@class='fa fa-exchange rotate90']");
	By availableBerth=By.xpath("//label[contains(text(),'Train with Available Berth')]");
	
	By searchButton=By.xpath("//button[contains(text(),'Search')]");
	By OK=By.xpath("//span[contains(text(),'OK')]");
	
	public TrainBookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public void originCity(String originCity) {
	 
		driver.findElement(origin).sendKeys(originCity);
	}
	
	public WebElement originDropdown() {
		 
		return driver.findElement(originDropdown);
	}
	
	public WebElement bookWithoutLoginDest() {
		 
		return driver.findElement(bookWithoutLoginDest);
	}
	
	public WebElement bookWithoutLoginOrigin() {
		 
		return driver.findElement(bookWithoutLoginOrigin);
	}
	
	public void destinationCity(String destinationCity) {
		driver.findElement(destination).sendKeys(destinationCity);
	}
	
	public WebElement destinationDropdown() {
		 
		return driver.findElement(destinationDropdown);
	}
	
	public WebElement quota() {
		 
		return driver.findElement(quota);
	}
	
	public WebElement quotaDropdown() {
		 
		return driver.findElement(quotaDropdown);
	}
	
	public WebElement calender() {
		 
		return driver.findElement(calender);
	}
	
	public List<WebElement> dateSelect() {
		 
		return driver.findElements(dateSelect);
	}
	
	public WebElement exchange() {
		 
		return driver.findElement(exchange);
	}
	
	public WebElement availableBerth() {
		 
		return driver.findElement(availableBerth);
	}
	
	public WebElement searchButton() {
		 
		return driver.findElement(searchButton);
	}
	
	public List<WebElement> okButton() {
		 
		return driver.findElements(OK);
	}
	
}