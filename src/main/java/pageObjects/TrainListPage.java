package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainListPage {

	public WebDriver driver;
	By available=By.xpath("//div[@class='white-back col-xs-12 ng-star-inserted']/table/tr/td/div/div[3]/strong");
	By classType=By.xpath("//div[@class='white-back col-xs-12 ng-star-inserted']/table/tr/td/div/div[1]/strong");
	By bookNow=By.xpath("//button[@class='btnDefault train_Search']");
	By agreeButton=By.xpath("//span[contains(text(),'I Agree')]");
	By yesButton=By.xpath("//span[contains(text(),'Yes')]");
	//p-confirmdialog[@class='ng-tns-c57-14']/div[1]/div[1]/div[3]/button[1]
	public TrainListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public List<WebElement> available() {
		return driver.findElements(available);
	}
	
	public List<WebElement> classType() {
		return driver.findElements(classType);
	}
	
	public WebElement bookNow() {
		return driver.findElement(bookNow);
	}
	
	public WebElement agreeButton() {
		return driver.findElement(agreeButton);
	}
	
	
	public List<WebElement> yesButton() {
		return driver.findElements(yesButton);
	}
	


	
}
