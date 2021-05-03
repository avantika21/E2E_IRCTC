package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HotelListPage {
	public WebDriver driver;
	By Book=By.xpath("//main/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/button");
	By continueBook=By.xpath("//div[@class='select-guest-rules-wrap']/button");
	public HotelListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	public WebElement Book() {
		return driver.findElement(Book);
	}
	public WebElement continueBook() {
		return driver.findElement(continueBook);
	}
	
}
