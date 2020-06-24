package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a/span[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;

	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	
/* //div/table/tbody/tr[2]/td[2]
 * //a[text()='test2 test2']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"))
 */
//	public void selectContactsByName(String name) { //test2 test2 =name
//		driver.findElement(By.xpath("//div/table/tbody/tr[+"+row+"+]/td[+"+col+"]")).click();
//				
//	}
	public void selectContactsByName() { //test2 test2 =name
		driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[2]")).click();
				
	}

	public void createNewContact(String title, String ftName, String ltName, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);

		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}
}
