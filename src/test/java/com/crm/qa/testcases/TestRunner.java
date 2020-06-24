package com.crm.qa.testcases;

import org.testng.TestNG;

import com.qa.ExtentReportListener.ExtentReporterListener;
/*NV-80 Runable JAR file Selenium --> convert the entire projact in a jar file and execute from anywhere
 * 1. go to the project --Rclick --export --java --Runable JAR file --next --select the TestRunner class 
 *  --> give the name and save as .jar (desktop or ..) -- select 1st option --finish. Done
 *  to run from the cmd/terminal -- go to the save location --> java -jar projectname.jar
 *   ** can send this jar file to manager/dev/ tester/ cusrtomer
 */ 
public class TestRunner {
	static TestNG testng;	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ExtentReporterListener listener= new ExtentReporterListener();
		testng =new TestNG();
		testng.setTestClasses(new Class [] {LoginPageTest.class,HomePageTest.class});
		testng.addListener(listener);
		testng.run();	
	}

}
