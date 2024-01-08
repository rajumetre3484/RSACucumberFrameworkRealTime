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
import utils.TestContextSetup;

public class LandingPageStepDefinition 
{
  WebDriver driver;
  public String landingPageproductName;
  public String offerPageProductName;
  TestContextSetup testContextSetup;
  LandingPage landingPage;
  
  public  LandingPageStepDefinition(TestContextSetup testContextSetup)  //first it will execute
  {
	  this.testContextSetup=testContextSetup;
	  this.landingPage = testContextSetup.pageObjectmanager.getLandingPage();// it will execute for two below methods thats way decalared in here first it will execute
  }
  
 
  @Given("User is on GreenCart Landing page")
  public void user_is_on_green_cart_landing_page() throws IOException 
 {
     //  landingPage = testContextSetup.pageObjectmanager.getLandingPage(); avoid here and below  declared in constructors
               Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
 }


   @When("^User searched with Shortname (.+) and extracted actul name of product$")
 public void user_searched_with_shortname_and_extracted_actul_name_of_product(String shortName) throws InterruptedException 
  {
	 //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName); instead of this below are used
	 //  LandingPage landingPage = new LandingPage(testContextSetup.driver);
	 //  landingPage = testContextSetup.pageObjectmanager.getLandingPage(); its in declared in constructor 
	   landingPage.searchItem(shortName);
	   Thread.sleep(2000);
	 
// testContextSetup.landingPageproductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	  testContextSetup.landingPageproductName=landingPage.getProductName().split("-")[0].trim();
	 System.out.println(landingPageproductName +"productName is extracted from Home page");
    
  }
   
   @When("Added {string} items of the selected-product to cart")
   public void added_items_of_the_selected_product_to_cart(String quantity) 
   {
	   landingPage.incrementQuantity(Integer.parseInt(quantity)); // here converted string to integer
	   landingPage.addToCart();

   }
 
  
}
