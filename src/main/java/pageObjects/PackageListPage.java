package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PackageListPage {

	public WebDriver driver;
	By bookButton=By.xpath("//tourpackagelist/main/div/section/div/div[2]/div/div[2]/div[2]/div[2]/a[2]");
	
	
	public PackageListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement bookButton() {
		return driver.findElement(bookButton);
	}

}
