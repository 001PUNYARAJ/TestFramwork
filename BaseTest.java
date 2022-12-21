package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = null;
	public static Properties property = new Properties();
	public static Properties loc = new Properties();

	@BeforeTest
	public void setUp() throws IOException {
		// Lunch browser

	if (driver == null) {

	FileInputStream input = new FileInputStream(
	"C:\\Users\\manan\\eclipse-workspace\\TestautomationFramwork\\src\\test\\resources\\configFiles\\config.properties");
	
	FileInputStream input2 = new FileInputStream(
	"C:\\Users\\manan\\eclipse-workspace\\TestautomationFramwork\\src\\test\\resources\\configFiles\\locators.properties");
	property.load(input);	
	loc.load(input2);
		}
			if (property.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(property.getProperty("baseUrl"));
//				driver.get("https://www.saucedemo.com/");
				driver.manage().window().maximize();
				
			} else if (property.get("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(property.getProperty("baseUrl"));
//				driver.get("https://www.saucedemo.com/");

			}
		}
	
	@AfterTest
	public void tearDown() {					// Closed browser
		driver.close();	
	}
}
