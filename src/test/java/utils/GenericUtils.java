package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils   // all the re-usable code is written here and used in stepdefinition
{
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)  // created constructor because to initilize the below driver
	{
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		    Set<String> s1 = driver.getWindowHandles();//total windows id
	 	    Iterator<String> i1 = s1.iterator();//windows from index
	 	    String parentWindow = i1.next();// index(0)-parent
	 	    String childWindow = i1.next();// index(1)-child
	 	    
	 	    driver.switchTo().window(childWindow); // control will swicth here parent to child completely
	 	    
		
	}
	
}
