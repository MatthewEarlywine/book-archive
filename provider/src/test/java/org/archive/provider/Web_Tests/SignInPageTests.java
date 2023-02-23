package org.archive.provider.Web_Tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInPageTests {

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
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

	@Test(priority=1)
	public void loadLogInPage() {
		driver.get("http://localhost:4200/");
		WebElement result1 = driver.findElement(By.name("siteTitle"));
		String expected1 = "Book Archive";
		assertEquals(result1.getText(), expected1);

		WebElement result2 = driver.findElement(By.name("userNameBanner"));
		String expected2 = "User Name:";
		assertEquals(result2.getText(), expected2);

		WebElement result3 = driver.findElement(By.name("username"));
		assertTrue(result3.isDisplayed());

		WebElement result4 = driver.findElement(By.name("passwordBanner"));
		String expected4 = "Password:";
		assertEquals(result4.getText(), expected4);

		WebElement result5 = driver.findElement(By.name("password"));
		assertTrue(result5.isDisplayed());
	}

	@Test(priority=2)
	public void signIn_badUserName1() {
		driver.get("http://localhost:4200/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));

		username.sendKeys("user"); // user name must be eight characters long, no spaces
		password.sendKeys("aaaaaaaa");

		submit.click();

		new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));

		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, "http://localhost:4200/login");

		WebElement result1 = driver.findElement(By.name("siteTitle"));
		String expected1 = "Book Archive";
		assertEquals(result1.getText(), expected1);

		WebElement errorMessage = driver.findElement(By.name("errorMessage"));
		assertTrue(errorMessage.isDisplayed());
	}

	@Test(priority=3)
	public void signIn_badUserName2() {
		driver.get("http://localhost:4200/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));

		username.sendKeys("super duper"); // user name must be eight characters long, no spaces
		password.sendKeys("aaaaaaaa");

		submit.click();

		new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));

		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, "http://localhost:4200/login");

		WebElement result1 = driver.findElement(By.name("siteTitle"));
		String expected1 = "Book Archive";
		assertEquals(result1.getText(), expected1);

		WebElement errorMessage = driver.findElement(By.name("errorMessage"));
		assertTrue(errorMessage.isDisplayed());
	}

	@Test(priority=4)
	public void signIn_badPassword1() {
		driver.get("http://localhost:4200/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));

		username.sendKeys("superduper");
		password.sendKeys("ggggggg"); // password must be eight characters long, no spaces

		submit.click();

		new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));

		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, "http://localhost:4200/login");

		WebElement result1 = driver.findElement(By.name("siteTitle"));
		String expected1 = "Book Archive";
		assertEquals(result1.getText(), expected1);

		WebElement errorMessage = driver.findElement(By.name("errorMessage"));
		assertTrue(errorMessage.isDisplayed());
	}

	@Test(priority=5)
	public void signIn_badPassword2() {
		driver.get("http://localhost:4200/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));

		username.sendKeys("superduper");
		password.sendKeys("ggg gggg"); // password must be eight characters long, no spaces

		submit.click();

		new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));

		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, "http://localhost:4200/login");

		WebElement result1 = driver.findElement(By.name("siteTitle"));
		String expected1 = "Book Archive";
		assertEquals(result1.getText(), expected1);

		WebElement errorMessage = driver.findElement(By.name("errorMessage"));
		assertTrue(errorMessage.isDisplayed());
	}

	@Test(priority=6)
	public void signIn_Correctly_goToLandingPage() {
		driver.get("http://localhost:4200/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));

		username.sendKeys("superduper");
		password.sendKeys("llllllll");

		submit.click();

		new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.urlToBe("http://localhost:4200/home"));

		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, "http://localhost:4200/home");

		WebElement result1 = driver.findElement(By.name("landingPageTitle"));
		String expected1 = "Welcome to the Archive";
		assertEquals(result1.getText(), expected1);
	}

}
