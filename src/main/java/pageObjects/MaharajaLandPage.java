package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MaharajaLandPage {
	public WebDriver driver;
	By loginBtn=By.xpath("//ul[@class='navbar-nav nav-icon-custom nav-login']/li/a");
	By BookBtn=By.xpath("//div[@class='book-now-wrap']/a");
	By username=By.xpath("//input[@id='modalLRInput10']");
	By password=By.xpath("//input[@id='modalLRInput11']");
	By signinBtn=By.xpath("//div[@class='text-center mt-2']/button");
	
	public MaharajaLandPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement loginBtn() {
		return driver.findElement(loginBtn);
	}
	
	public WebElement BookBtn() {
		return driver.findElement(BookBtn);
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement signinBtn() {
		return driver.findElement(signinBtn);
	}
}
