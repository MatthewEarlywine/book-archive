package org.archive.provider.Web_Tests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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

public class ListPageTests {
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	public static int convert(String str) {
		int val = 0;
		
		try {
            val = Integer.parseInt(str);
        }
		catch (NumberFormatException e) {
			System.out.println("Invalid String");
		}
		return val;
	}
	
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
	public void goFromLandingPage_toBookListPage() {
		driver.get("http://localhost:8081/");
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));
		
		username.sendKeys("superduper");
		password.sendKeys("llllllll");
		
		submit.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe("http://localhost:8081/login"));
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals(currentUrl, "http://localhost:8081/login");
		
		WebElement result1 = driver.findElement(By.className("landingPageTitle"));
		String expected1 = "Welcome to the Archive";
		assertEquals(result1.getText(), expected1);	
		
		WebElement listButton = driver.findElement(By.className("BookListButton"));
		
		listButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe("http://localhost:8081/api/favoritebooks/"));
		
		String currentUrl2 = driver.getCurrentUrl();
		assertEquals(currentUrl2, "http://localhost:8081/api/favoritebooks/");
		
		WebElement result2 = driver.findElement(By.className("bookListTitle"));
		String expected2 = "List of Favorite Books";
		assertEquals(result2.getText(), expected2);
		
		WebElement titleLabel = driver.findElement(By.name("titleLabel"));
		WebElement titleInput = driver.findElement(By.name("titleInput"));
		
		String expectedLabel_Title = "Title:";
		assertEquals(titleLabel.getText(), expectedLabel_Title);
		assertTrue(titleInput.isDisplayed());
		
		WebElement seriesLabel = driver.findElement(By.name("seriesLabel"));
		WebElement seriesInput = driver.findElement(By.name("seriesInput"));
		
		String expectedLabel_Series = "Series:";
		assertEquals(seriesLabel.getText(), expectedLabel_Series);
		assertTrue(seriesInput.isDisplayed());
		
		WebElement authorLabel = driver.findElement(By.name("authorLabel"));
		WebElement authorInput = driver.findElement(By.name("authorInput"));
		
		String expectedLabel_Author = "Author:";
		assertEquals(authorLabel.getText(), expectedLabel_Author);
		assertTrue(authorInput.isDisplayed());
		
		WebElement illustratorLabel = driver.findElement(By.name("illustratorLabel"));
		WebElement illustratorInput = driver.findElement(By.name("illustratorInput"));
		
		String expectedLabel_Illustrator = "Illustrator:";
		assertEquals(illustratorLabel.getText(), expectedLabel_Illustrator);
		assertTrue(illustratorInput.isDisplayed());
		
		WebElement genreLabel = driver.findElement(By.name("genreLabel"));
		WebElement genreInput = driver.findElement(By.name("genreInput"));
		
		String expectedLabel_Genre = "Genre:";
		assertEquals(genreLabel.getText(), expectedLabel_Genre);
		assertTrue(genreInput.isDisplayed());
		
		WebElement submitBookButton = driver.findElement(By.name("submitBookBtn"));
		assertTrue(submitBookButton.isDisplayed());
		
		WebElement columnId = driver.findElement(By.name("columnId"));
		String expectedColumnId = "Book Id";
		assertEquals(columnId.getText(), expectedColumnId);
		
		WebElement columnTitle = driver.findElement(By.name("columnTitle"));
		String expectedColumnTitle = "Title";
		assertEquals(columnTitle.getText(), expectedColumnTitle);
		
		WebElement columnAuthor = driver.findElement(By.name("columnAuthor"));
		String expectedColumnAuthor = "Author";
		assertEquals(columnAuthor.getText(), expectedColumnAuthor);
		
		WebElement columnSeries = driver.findElement(By.name("columnSeries"));
		String expectedColumnSeries = "Series";
		assertEquals(columnSeries.getText(), expectedColumnSeries);
		
		WebElement columnIllustrator = driver.findElement(By.name("columnIllustrator"));
		String expectedColumnIllustrator = "Illustrator";
		assertEquals(columnIllustrator.getText(), expectedColumnIllustrator);
		
		WebElement columnGenre = driver.findElement(By.name("columnGenre"));
		String expectedColumnGenre = "Genre";
		assertEquals(columnGenre.getText(), expectedColumnGenre);
		
		boolean flag = false;
		
		List<WebElement> bookList = driver.findElements(By.id("bookList"));
		WebElement bookId = driver.findElement(By.id("bookId"));
		WebElement bookTitle = driver.findElement(By.id("bookTitle"));
		WebElement bookSeries = driver.findElement(By.id("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.id("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.id("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.id("bookGenre"));
		WebElement editBtn = driver.findElement(By.id("editBtn"));
		WebElement deleteBtn = driver.findElement(By.id("deleteBtn"));
		
		for(WebElement book:bookList) {
			assertTrue(bookTitle.isDisplayed());
			assertTrue(bookAuthor.isDisplayed());
			assertTrue(editBtn.isDisplayed());
			assertTrue(deleteBtn.isDisplayed());
			
			if(bookId.getText().equals("1")){
				assertEquals(bookTitle.getText(), "Frankenstein");
				assertEquals(bookAuthor.getText(), "Mary Shelly");
				assertEquals(bookGenre.getText(), "Horror");
			}
			if(bookId.getText().equals("2")){
				assertEquals(bookTitle.getText(), "Exalted");
				assertEquals(bookSeries.getText(), "Exalted");
				assertEquals(bookAuthor.getText(), "Onyx Path Publishing");
				assertEquals(bookGenre.getText(), "RPG");
			}
			if(bookId.getText().equals("3")){
				assertEquals(bookTitle.getText(), "After Man");
				assertEquals(bookAuthor.getText(), "Dougal Dixon");
				assertEquals(bookGenre.getText(), "Science Fiction");
			}					
		}	
	}
	
	@Test(priority=2)
	public void addBook_withGoodData() {
		driver.get("http://localhost:8081/");
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));
		
		username.sendKeys("superduper");
		password.sendKeys("llllllll");
		
		submit.click();
		
		WebElement listButton = driver.findElement(By.className("BookListButton"));
		
		listButton.click();
		
		WebElement titleInput = driver.findElement(By.name("titleInput"));
		WebElement seriesInput = driver.findElement(By.name("seriesInput"));
		WebElement authorInput = driver.findElement(By.name("authorInput"));
		WebElement illustratorInput = driver.findElement(By.name("illustratorInput"));
		WebElement genreInput = driver.findElement(By.name("genreInput"));
		
		WebElement submitBookButton = driver.findElement(By.name("submitBookBtn"));
		
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		
		titleInput.sendKeys("Dracula");
		seriesInput.sendKeys("Horror Classics");
		authorInput.sendKeys("Bram Stoker");
		illustratorInput.sendKeys("House of Carfax");
		genreInput.sendKeys("Horror");
		
		submitBookButton.click();
		
		bookList = driver.findElements(By.id("bookList"));
		
//		assertEquals(bookList.size(), 4);
		
		WebElement bookId = driver.findElement(By.id("bookId"));
		WebElement bookTitle = driver.findElement(By.id("bookTitle"));
		WebElement bookSeries = driver.findElement(By.id("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.id("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.id("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.id("bookGenre"));
		
		for(WebElement book:bookList) {
			if(bookTitle.getText().equals("Dracula")) {
				assertEquals(bookId.getText(), "4");
			}
			
		}
				
		if((bookList.size()-1) == convert(bookId.getText())) {
			assertEquals(bookTitle.getText(), "Dracula");
			assertEquals(bookSeries.getText(), "Horror Classics");
			assertEquals(bookAuthor.getText(), "Bram Stoker");
			assertEquals(bookIllustrator.getText(), "House of Carfax");
			assertEquals(bookGenre.getText(), "Horror");
		}		
	}
	
	@Test(priority=3)
	public void editBook_withGoodData() {
		driver.get("http://localhost:8081/");
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));
		
		username.sendKeys("superduper");
		password.sendKeys("llllllll");
		
		submit.click();
		
		WebElement listButton = driver.findElement(By.className("BookListButton"));
		
		listButton.click();
		
		WebElement titleInput = driver.findElement(By.name("titleInput"));
		WebElement seriesInput = driver.findElement(By.name("seriesInput"));
		WebElement authorInput = driver.findElement(By.name("authorInput"));
		WebElement illustratorInput = driver.findElement(By.name("illustratorInput"));
		WebElement genreInput = driver.findElement(By.name("genreInput"));
		
		WebElement bookId = driver.findElement(By.id("bookId"));
		WebElement bookTitle = driver.findElement(By.id("bookTitle"));
		WebElement bookSeries = driver.findElement(By.id("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.id("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.id("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.id("bookGenre"));
		
		WebElement editBtn = driver.findElement(By.id("editBtn"));
		
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		
		for(WebElement book:bookList) {
			if(bookId.getText().equals("1")) {
				editBtn.click();
			}
		}
		
		WebElement updateBookButton = driver.findElement(By.name("updateBookBtn"));
				
		titleInput.clear();
		
		titleInput.sendKeys("Frank");
		
		updateBookButton.click();
		
		driver.navigate().refresh();
		
		bookId = driver.findElement(By.id("bookId"));
		bookTitle = driver.findElement(By.id("bookTitle"));
		bookAuthor = driver.findElement(By.id("bookAuthor"));
		
		for(WebElement book:bookList) {
			if(bookId.getText().equals("1")) {
				assertEquals(bookTitle.getText(), "Frank");
				assertEquals(bookAuthor.getText(), "Mary Shelly");	
			}
		}

	}
}
