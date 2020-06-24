package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
    //how do you increase your scrit performance??
	@FindBy(xpath ="//div/span[contains(text(),'MD MD')]")
	WebElement userNameLabel;
	
	//@CacheLookup  //.....will store in the cache memory instead of searching into the page/browsr everytime
      // this will increase the script performance BUT the problem is that 
	  //if the PAGE got refresh//DOM(document objectModel) changed the cache property will be corrupt  
	 //--->>>it will give the StateElementException ----object not found 

	@FindBy(xpath = "//a/span[contains(text(),'Contacts')]")
	WebElement contactsLink; 
	@FindBy(xpath = "//a/button[@class='ui linkedin button']")
	WebElement newContactLink; 
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
    
	//belowing pages will return that pages(contacts,deals..) and we gonna assert the test class
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
    //mouseOver 
	public void clickOnNewContactLink() {
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();

	}

}
