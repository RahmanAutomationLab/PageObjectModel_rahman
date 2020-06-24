/*
 * @author Naveen Khunteta
 * What is the Eclipse shortcut for Open Declaration?
   Keep your courser on methods (clicking the mouse) and press Ctrl !.
 */

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.datareader.DataReader;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			testUtil.switchToFrame();
			}catch(Exception  e){	
				System.out.println("frame not found");
			}
		contactsPage = homePage.clickOnContactsLink();
	}

	//@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	//@Test(priority = 2)
	public void selectSingleContactsTest() {
		//contactsPage.selectContactsByName("MD RAHMAN");
		contactsPage.selectContactsByName();
	}

	//@Test(priority = 3)
	public void selectMultipleContactsTest() {
//		contactsPage.selectContactsByName("Sam Sam");
//		contactsPage.selectContactsByName("MD RAHMAN");
		contactsPage.selectContactsByName();

	}
	
	//Below v--4  https://www.youtube.com/watch?v=H2-3w-GQZ3g&list=PLFGoYjJG_fqq6cHeqfsDes3pdVh3kpl74&index=4
	/* 1. create a contact data excel sheet
	 * 
	 * 
	 */
	/*//N B:Instead of creating method  in TestUtil class, 
	//I have seperated the reader class in seperate package
	
	@DataProvider  
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	*/

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = DataReader.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
