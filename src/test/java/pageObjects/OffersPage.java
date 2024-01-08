package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage 
{
	WebDriver driver;
  
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void getsearchItems(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getproductName()
	{
		return driver.findElement(productName).getText();
	}

}
