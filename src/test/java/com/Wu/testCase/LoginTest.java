package com.Wu.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Wu.base.Testbase;

public class LoginTest extends Testbase {

	@Test
	public void registeration() {
		log.debug("Inside login Test");
		driver.findElement(By.name(OR.getProperty("firstName"))).sendKeys("Abhishek");
		driver.findElement(By.name(OR.getProperty("phone"))).sendKeys("9582300150");
		driver.findElement(By.name(OR.getProperty("email"))).sendKeys("Abhishekguptarock89@gmail.com");
		WebElement SelectCountry = driver.findElement(By.name(OR.getProperty("dropdown")));

		Select country = new Select(SelectCountry);
		country.selectByValue("Germany");
		driver.findElement(By.name(OR.getProperty("city"))).sendKeys("Delhi");
		driver.findElement(By.xpath(OR.getProperty("id"))).sendKeys("Abhishek");
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys("rock@0589");
		driver.findElement(By.xpath(OR.getProperty("submit"))).click();
		log.debug("LoginTest successful!! ");

		WebElement message = driver.findElement(By.xpath("//p[@id='alert']"));
		String act_msg=message.getText();
		//System.out.println(message);
		
		String exp_msg="Username or Password already exists.";
		
		Assert.assertEquals(act_msg,exp_msg);

	}

	// public static void main(String[]args) throws IOException
	// {
	// Properties pro=new Properties();
	// FileInputStream fis=new
	// FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	// pro.load(fis);
	// System.out.println(pro.getProperty("firstName"));
	// }
}
