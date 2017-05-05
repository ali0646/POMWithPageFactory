package com.test.automation.testAutomation.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.testAutomation.testBase.TestBase;
import com.test.automation.testAutomation.uiActions.HomePage;

public class TC002_VerifyRegistrationDetails extends TestBase {
	
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	HomePage homePage;
	
	@BeforeTest
	public void setUp()
	{
		init();
	
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("==================Starting verfying with invalid credentials====================");
		driver.findElement(By.id("email_create")).sendKeys("Test23@gmail.com");
		log.info("==================Finished verfying with invalid credentials====================");
	}
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}
