package testBase;

import java.awt.event.ActionEvent;
import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TaskPage;
import reuseableComponents.ActionsEngine;
import reuseableComponents.DB_Operations;
//import reuseableComponents.AlertHandling;
//import reuseableComponents.ClickElement;
//import reuseableComponents.DropDownHandling;
import reuseableComponents.PropertiesOperations;

public class TestBase extends ActionsEngine {
	BrowserFactory bf = new BrowserFactory();

	



	@BeforeMethod
	  public void openBrowser() throws Exception {
			
			String browser = PropertiesOperations.getPropertyValueByKey("browser");
			String url = 	PropertiesOperations.getPropertyValueByKey("url");
			

			DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));

			DriverFactory.getInstance().getDriver().manage().window().maximize();
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			DriverFactory.getInstance().getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			DriverFactory.getInstance().getDriver().navigate().to(url);			
			
	}
		
	
	@AfterMethod
	  public void closeBrowser() {
		  System.out.println("Browser close");
		  DriverFactory.getInstance().quitDriver();
	  }
	
	
}
