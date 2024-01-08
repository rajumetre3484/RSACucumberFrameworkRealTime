package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		//FileInputStream fis = new FileInputStream("C://Users//Admin//eclipse-workspace//CucumberFrameworkRealTime//src//test//resources//global.properties");
		 Properties prop = new Properties();
		 prop.load(fis);
		 String url = prop.getProperty("QAUrl");
		 String browser_properties = prop.getProperty("browser");
		  String browser_maven = System.getProperty("browser");  // user for mvn cmd for browser
		  //result = testCondition ? Value1 : Value2; 
		  
		String  browser = browser_maven!=null ? browser_maven : browser_properties; // user for mvn cmd for browser
		  
		
		if(driver==null)  //here driver is not initialize then to go below step 
		{                // when first executing it should be null and it will initilize driver 
			if(browser.equalsIgnoreCase("chrome"))
			{
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver(); //driver gets the life
			} 
			if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.chromedriver().setup();
				driver =new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.get(url);
		    driver.manage().window().maximize();
		}
		   return driver;   //  if driver is alredy initilize then simply returs the driver. 
		                 // in this way the driver is initilize once in the test
	}

}
