package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver d_driver;
	public static WebEventListener eventListener;
	
	//this is the "super constractor"
	public TestBase() {
		try{
			prop=new Properties();
			FileInputStream ip = new FileInputStream(
			System.getProperty("user.dir") + "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
			
			//FileInputStream ip= new FileInputStream(System.getProperty("C:\\Users\\rahma\\eclipse-workspace\\POM_Practice\\src\\main\\java\\com\\crm\\qa\\config\\config.properties"));
		    //prop.load(ip);//------>>> Not the currect formate!
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
 public static void initialization() {
	 String browserName =prop.getProperty("browser");
	 if (browserName.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahma\\Downloads\\chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 else if (browserName.equals("FF")) {
		 System.setProperty("webdriver.gecko.driver","\"C:\\Users\\rahma\\Downloads\\geckodriver.exe\"");
		 driver=new FirefoxDriver();
	 }
	 // video-#4
	 /*creating the obj to the obj of eventlistenerClass
	  * 
	  */
		d_driver = new EventFiringWebDriver(driver); //create a obj of EventFiringWebDriver and 
		//reff. d_driver then pass the regular driver
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		d_driver.register(eventListener);
		driver = d_driver;
 
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 //set into util class
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		 driver.get(prop.getProperty("url")); 
	 }
}
