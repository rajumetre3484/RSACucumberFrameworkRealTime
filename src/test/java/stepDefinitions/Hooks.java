package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks 
{
	TestContextSetup textContextSetup;
	
	public Hooks(TestContextSetup textContextSetup)
	{
		this.textContextSetup = textContextSetup;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
      textContextSetup.testBase.WebDriverManager().quit();    //call driver from TestBase class so create object of Testbase class avoid the creations of object in scripts-
		                                                     //and all object contains the TestContextSetup class to call this instancies variable so create the constructor of current class  
	}                                                         // and pass driver from textContextSetup and gloably also created.

	@AfterStep
	public void AddScreenshot(Scenario scenaro) throws IOException
	{
		WebDriver driver = textContextSetup.testBase.WebDriverManager();
		
		if(scenaro.isFailed())
		{
			//screenshot
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);// converting file to byte
			 scenaro.attach(fileContent, "image/png", "image");//its in byte formate
	   }
	
   }
}
