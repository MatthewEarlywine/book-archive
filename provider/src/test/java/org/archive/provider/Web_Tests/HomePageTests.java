package org.archive.provider.Web_Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTests {
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	public static WebDriver driver = null;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void cleanse() {
		driver.close();
	}
	
	@Test
	public void getIndexPage() {
		driver.get("http://localhost:8081/");
		WebElement result = driver.findElement(By.className("siteTitle"));
		String expected = "Book Archive";
		assertEquals(result.getText(), expected);
	}
}
