package com.test.automation.testAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String browser="Chrome";
	
	public void init()
	{
		SelectBrowser(browser);
		getURL(url);
		String log4jConfPath="log4j.proporties";
		PropertyConfigurator.configure(log4jConfPath);
	
	}


	private void SelectBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		log.info("Creating object of: "+browser);
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+ "/drivers/geckodriver");
			log.info("Creating object of: "+browser);
			driver=new FirefoxDriver();
		}
		else
		{
			throw new IllegalArgumentException("The supplied browser"+ browser +"is not supported at this time.");
		}
	}
	private void getURL(String url) {
		log.info("Navigating to url: "+url);
		driver.get(url);
		log.info("Maximizing Window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
