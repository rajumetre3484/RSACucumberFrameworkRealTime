package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectmanager
{
	public LandingPage landingPage;
	public OffersPage offersPage;
	public WebDriver driver;
	public CheckoutPage checkoutPage;
	
	public PageObjectmanager(WebDriver driver)   // Constructor to initialise the browser, WebDriver driver is initialize from TestContextSetup
	{
		this.driver = driver;
	}
	
	
	
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage OffersPage()
	{
		 offersPage = new OffersPage(driver);
		 return offersPage;
	}
	
	public CheckoutPage getCheckoutPge()
	{
		CheckoutPage checkoutPge = new CheckoutPage(driver);
		return checkoutPge;
	}


}
