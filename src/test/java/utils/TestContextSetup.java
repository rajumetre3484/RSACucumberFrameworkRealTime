package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectmanager;


public class TestContextSetup 
{
	  public WebDriver driver;
	  public String landingPageproductName;
	  public PageObjectmanager pageObjectmanager;
	  public TestBase testBase;
	  public GenericUtils genericUtils;
	  
	  public TestContextSetup() throws IOException // this will execute in class first
	  {
		  testBase = new TestBase();
         // pageObjectmanager =new PageObjectmanager(driver);  passing driver below from generic  driver method
          pageObjectmanager =new PageObjectmanager(testBase.WebDriverManager()); //getting driver fron testBase
          genericUtils = new GenericUtils(testBase.WebDriverManager());
	  }
	  

}
