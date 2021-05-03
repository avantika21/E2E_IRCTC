package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightListPage {

	public WebDriver driver;
	By bookBtn=By.xpath("//div[@class='SearchData_List_in SearchData_Book']/button[contains(text(),'Book')]");
	By gstNo=By.xpath("//div[@class='modal-footer text-center p-2 mx-auto']/button[contains(text(),'No')]");
	By bookBtnR=By.xpath("//div[@class='bottom-flightdetails-right text-center mt-2']/button[contains(text(),'Book')]");
	By addInfo=By.xpath("//div[@class='col-12 text-center my-2']/button[2]");
	By normalFare=By.xpath("//div[@id='modalflexiFare']/div/div/div[3]/button[2]");
	//div[@class='col-12 text-center my-2']/button[2]
	
	public FlightListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement normalFare() {
		return driver.findElement(normalFare);
	}
	
	public WebElement bookBtn() {
		return driver.findElement(bookBtn);
	}
	
	public WebElement bookBtnR() {
		return driver.findElement(bookBtnR);
	}
	
	public WebElement addInfo() {
		return driver.findElement(addInfo);
	}
	
	public WebElement gstNo() {
		return driver.findElement(gstNo);
	}
}
