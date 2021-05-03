package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PackageLoginPage {

	public WebDriver driver;
	By Username=By.xpath("//input[@id='modalPBRInput10']");
	By Password=By.xpath("//input[@id='modalPBRInput11']");
	By signinBtn=By.xpath("//booklogin/main/div/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]");
	
	public PackageLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement Username() {
		return driver.findElement(Username);
	}
	
	public WebElement Password() {
		return driver.findElement(Password);
	}
	
	public WebElement signinBtn() {
		return driver.findElement(signinBtn);
	}

}
