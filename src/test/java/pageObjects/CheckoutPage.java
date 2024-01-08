package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage
{
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	
	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(.,'Place Order')]");
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
}
	
	
	
	
	