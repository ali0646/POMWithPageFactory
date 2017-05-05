package com.test.automation.testAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.testAutomation.testBase.TestBase;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement logInEmailAddress;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement logInPassword;
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement logInSubmitButton;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String email,String password)
	{
		signIn.click();
		log.info("Clicked on signin Button and the object is:"+signIn.toString());
		
		logInEmailAddress.sendKeys(email);
		log.info("Entered email address and the object is:"+logInEmailAddress.toString());
		
		logInPassword.sendKeys(password);
		log.info("Entered password and the object is:"+logInPassword.toString());
		
		logInSubmitButton.click();
		log.info("Clicked on Submit Button and the object is:"+logInSubmitButton.toString());
	}
	
	public String getInvalidLoginText()
	{
		log.info("Error Message  is:"+authenticationFailed.getText());
		return authenticationFailed.getText();
		
	}
}
