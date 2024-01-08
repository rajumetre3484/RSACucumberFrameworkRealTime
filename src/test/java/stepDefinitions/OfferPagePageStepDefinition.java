package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectmanager;
import utils.TestBase;
import utils.TestContextSetup;

public class OfferPagePageStepDefinition 
{
  public String offerPageProductName;
  TestContextSetup testContextSetup;
  PageObjectmanager pageObjectmanager;
  
  public OfferPagePageStepDefinition(TestContextSetup testContextSetup)
  {
	  this.testContextSetup=testContextSetup;
  }
  
   @Then("^User searched for (.+) shortname in offers page$")
 public void user_searched_for_the_same_shortname_in_offers_page(String shortName) throws InterruptedException 
 {
	   //offer page->enter->grab text
	   
	   switchToOffersPage();  
	   
    //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	//   OffersPage offersPage = new OffersPage(testContextSetup.driver);
	   OffersPage   offersPage = testContextSetup.pageObjectmanager.OffersPage();
	   offersPage.getsearchItems(shortName);
       Thread.sleep(2000);
   // offerPageProductName = testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
       offerPageProductName =offersPage.getproductName();
 }
   public void switchToOffersPage()
   {
	   //if switched to offer page->skip below part
	  // if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
 	  
	   //testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	  // LandingPage landingPage = new LandingPage(testContextSetup.driver); instead of this used POM
	//   pageObjectmanager = new PageObjectmanager(testContextSetup.driver);  again new operator so used DI method so go to testContextSetup create constructor
	  
	   LandingPage landingPage = testContextSetup.pageObjectmanager.getLandingPage();
	    
	   landingPage.selectTopDealPage();
 	   /* Set<String> s1 = testContextSetup.driver.getWindowHandles();//total windows id
 	    Iterator<String> i1 = s1.iterator();//windows from index
 	    String parentWindow = i1.next();// index(0)-parent            /// moved  to GenericUtils
 	    String childWindow = i1.next();// index(1)-child
 	    
 	    testContextSetup.driver.switchTo().window(childWindow);*/ // control will swicth here parent to child completely
 	    
	      testContextSetup.genericUtils.SwitchWindowToChild();
   }
   
   
  @Then("Validate product name in offers page matches with landing Page")
  public void validate_product_name_in_offers_page() throws IOException
  {
	 Assert.assertEquals(offerPageProductName,testContextSetup.landingPageproductName);
	// testContextSetup.testBase.WebDriverManager().quit();
	 
	
  }
  
  
}
