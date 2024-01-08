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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition 
{
  WebDriver driver;
  public String landingPageproductName;
  public String offerPageProductName;
  TestContextSetup testContextSetup;
  public CheckoutPage checkoutPage;
  
  public  CheckoutPageStepDefinition(TestContextSetup testContextSetup)  //first it will execute
  {
	 this.testContextSetup=testContextSetup;
	 this.checkoutPage = testContextSetup.pageObjectmanager.getCheckoutPge();
  }
  

  @Then("Varify user has ability to enter promo code and place the order")
  public void varify_user_has_ability_to_enter_promo_code_and_place_the_order() 
  {
	 //  checkoutPage = testContextSetup.pageObjectmanager.getCheckoutPge();// it will put under  constructor it will execute first and give life for both methods
	   Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	   Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
  }
  
  @Then("^User proceeds to Checkout and Validate the (.+) items in checkout page$")
  public void user_proceeds_to_checkout(String name) throws InterruptedException  // this execute after above one need checkoutPage rev ref if written its can duplicate 
  {
	  checkoutPage.CheckoutItems();
	  //Assertion to extract name from screen and compare with name need to write code for us
  }



 
 
  
}
