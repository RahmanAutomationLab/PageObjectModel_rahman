package com.crm.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory / OR
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']/span[2]")
	WebElement loginBtn1;
	@FindBy(xpath="//input[@name='email']") 
	WebElement username;
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn2;
	
	@FindBy(xpath="//*[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(css="div > a > svg > image")                   //   "//img[contains(@class,'img-responsive')]") //
	WebElement crmLogo;

	//most of the cases PageFactory no need to use driver.findElement By..> 
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver,this); //this=LoginPage.class this means current class objects
	}
	//Actions:
		public String validateLoginPageTitle(){
			 return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		public HomePage login(String un, String pwd){
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", loginBtn1);
	    	username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn2.click();
			    	
			return new HomePage();
		}

}