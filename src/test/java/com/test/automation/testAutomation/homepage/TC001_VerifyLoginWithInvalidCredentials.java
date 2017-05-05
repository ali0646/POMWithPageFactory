package com.test.automation.testAutomation.homepage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.automation.testAutomation.testBase.TestBase;
import com.test.automation.testAutomation.uiActions.HomePage;


public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {

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
		homePage=new HomePage(driver);
		homePage.loginToApplication("test@gmail.com", "password");
		Assert.assertEquals("Authentication failed.", homePage.getInvalidLoginText());
		log.info("==================Finished verfying with invalid credentials====================");
	}
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}
