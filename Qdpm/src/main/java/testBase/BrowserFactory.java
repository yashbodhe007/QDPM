package testBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	//create webdriver object for given browser
		public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

			WebDriver driver = null;
//			RemoteWebDriver driver = null;

			if(browser.equalsIgnoreCase("Chrome")) {

//				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);

			}else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.addArguments("-private");						
				driver = new FirefoxDriver(foptions);

			}else if (browser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				InternetExplorerOptions iOptions = new InternetExplorerOptions();
				iOptions.addCommandSwitches("-private");
				driver = new InternetExplorerDriver(iOptions);
			}else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				EdgeOptions eoptions = new EdgeOptions();
				driver = new EdgeDriver(eoptions);
			}
			
			
			
			
			
			return driver;
		}

}
