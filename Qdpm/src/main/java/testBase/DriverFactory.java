package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	
	private DriverFactory() {
		
	}	
	
	private static DriverFactory instance  = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public  WebDriver getDriver() {
        return driver.get();
    }

    public  void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public  void quitDriver() {
    	 if (getDriver() != null) {
    	        getDriver().quit(); // Close the entire browser session
    	        driver.remove();
    	    }
    }
}
