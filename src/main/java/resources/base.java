package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public  WebDriver driver;
	public Properties prop;

	
public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("C:\\Users\\Avantika\\eclipse-workspace\\E2E.IRCTC\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equalsIgnoreCase("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "C://Users//Avantika//Desktop//jars//chromedriver.exe");
	driver= new ChromeDriver();
		//to execute in chrome driver
	
}
else if (browserName.equalsIgnoreCase("firefox"))
{
	 System.setProperty("webdriver.gecko.driver", "C://Users//Avantika//Desktop//jars//geckodriver.exe");
	 driver= new FirefoxDriver();
	//to execute in firefox driver
}
else if (browserName.equalsIgnoreCase("IE"))
{
	 System.setProperty("webdriver.ie.driver","C://Users//Avantika//Desktop//jars//IEDriverServer.exe");
	 driver=new InternetExplorerDriver(); 
	//to execute in IE driver
}

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.manage().window().maximize();
return driver;


}


}
