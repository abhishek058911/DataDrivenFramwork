package com.Wu.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class Testbase {
	/*
	 * WebDriver Excel properties logs ExtentReport ReportNG DB Mail
	 * 
	 * Logs-log4j jar,.log,log4j.properties,logger
	 */

	public static WebDriver driver;
	public static Properties pro;
	public static Properties OR;
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {

			try {
				 pro = new Properties();
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				pro.load(fis);
				log.debug("Config file loaded");
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			OR=new Properties();
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			log.debug("OR file loaded");
		}
		if (pro.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome lunched");

		} else if (pro.getProperty("Browser").equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox lunched");
		}

		driver.get(pro.getProperty("TestURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(pro.getProperty("Timeout")), TimeUnit.SECONDS);

	}
	
	//to check if element is present or not
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return  false;
		}
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		
		}
		log.debug("Test Execution Completed !!");
	}
}
