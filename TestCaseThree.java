package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class TestCaseThree extends BaseTest {

	@Test 
	public static void Login() {
		
		driver.manage().window().maximize();
		driver.findElement(By.id(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.id(loc.getProperty("loginButton"))).click();
	}
	
	@Test
	public static void CountItems() {
		driver.manage().window().maximize();
		driver.findElement(By.id(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.id(loc.getProperty("loginButton"))).click();	
		
		List<WebElement> items = driver.findElements(By.className(".inventory_item_name"));
		System.out.println(items.size());
	}
	
	@Test
	public static void GetTitle() {
		driver.manage().window().maximize();
		driver.findElement(By.id(loc.getProperty("username"))).sendKeys("standard_user");
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys("secret_sauce");
		driver.findElement(By.id(loc.getProperty("loginButton"))).click();	
		
		String title = driver.getTitle();
		System.out.println(title);
	}
	
}
