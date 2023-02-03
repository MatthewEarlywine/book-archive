package org.archive.provider.Web_Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
		
		int index = 0; 
		
		for(index=0; index <= bookList.size(); index++) {
					
			if(index == 0) {
				WebElement bookId = driver.findElement(By.id("bookId-0"));
				assertTrue(bookId.isDisplayed());
				assertEquals(bookId.getText(), "1");
				
				WebElement bookTitle = driver.findElement(By.id("bookTitle-0"));
				assertTrue(bookTitle.isDisplayed());
				assertEquals(bookTitle.getText(), "Frankenstein");
				
				WebElement bookAuthor = driver.findElement(By.id("bookAuthor-0"));
				assertTrue(bookAuthor.isDisplayed());
				assertEquals(bookAuthor.getText(), "Mary Shelly");
				
				WebElement bookGenre = driver.findElement(By.id("bookGenre-0"));
				assertTrue(bookGenre.isDisplayed());
				assertEquals(bookGenre.getText(), "Horror");
				
				WebElement editBtn = driver.findElement(By.id("editBtn-0"));
				WebElement deleteBtn = driver.findElement(By.id("deleteBtn-0"));
				assertTrue(editBtn.isDisplayed());
				assertTrue(deleteBtn.isDisplayed());
			}
		
			if(index == 1){
				WebElement bookId = driver.findElement(By.id("bookId-1"));
				assertTrue(bookId.isDisplayed());
				assertEquals(bookId.getText(), "2");
				
				WebElement bookTitle = driver.findElement(By.id("bookTitle-1"));
				assertTrue(bookTitle.isDisplayed());
				assertEquals(bookTitle.getText(), "Exalted");
				
				WebElement bookSeries = driver.findElement(By.id("bookSeries-1"));
				assertTrue(bookSeries.isDisplayed());
				assertEquals(bookSeries.getText(), "Exalted");
				
				WebElement bookAuthor = driver.findElement(By.id("bookAuthor-1"));
				assertTrue(bookAuthor.isDisplayed());
				assertEquals(bookAuthor.getText(), "Onyx Path Publishing");
				
				WebElement bookGenre = driver.findElement(By.id("bookGenre-1"));
				assertTrue(bookGenre.isDisplayed());
				assertEquals(bookGenre.getText(), "RPG");
				
				WebElement editBtn = driver.findElement(By.id("editBtn-1"));
				WebElement deleteBtn = driver.findElement(By.id("deleteBtn-1"));
				assertTrue(editBtn.isDisplayed());
				assertTrue(deleteBtn.isDisplayed());
			}
			
			if(index == 2){
				WebElement bookId = driver.findElement(By.id("bookId-2"));
				assertTrue(bookId.isDisplayed());
				assertEquals(bookId.getText(), "3");
				
				WebElement bookTitle = driver.findElement(By.id("bookTitle-2"));
				assertTrue(bookTitle.isDisplayed());
				assertEquals(bookTitle.getText(), "After Man");
				
				WebElement bookAuthor = driver.findElement(By.id("bookAuthor-2"));
				assertTrue(bookAuthor.isDisplayed());
				assertEquals(bookAuthor.getText(), "Dougal Dixon");
				
				WebElement bookGenre = driver.findElement(By.id("bookGenre-2"));
				assertTrue(bookGenre.isDisplayed());
				assertEquals(bookGenre.getText(), "Science Fiction");
				
				WebElement editBtn = driver.findElement(By.id("editBtn-2"));
				WebElement deleteBtn = driver.findElement(By.id("deleteBtn-2"));
				assertTrue(editBtn.isDisplayed());
				assertTrue(deleteBtn.isDisplayed());
			}
		}
	}
	
	@Test(priority=2)
	public void addBook_withBadTitleData() {
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
		
		titleInput.sendKeys("");
		seriesInput.sendKeys("Horror Classics");
		authorInput.sendKeys("Bram Stoker");
		illustratorInput.sendKeys("House of Carfax");
		genreInput.sendKeys("Horror");
		
		submitBookButton.click();
		
		bookList = driver.findElements(By.id("bookList"));
		
		assertEquals(bookList.size(), 3);
		
		WebElement bookId = driver.findElement(By.name("bookId"));
		WebElement bookTitle = driver.findElement(By.name("bookTitle"));
		WebElement bookSeries = driver.findElement(By.name("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.name("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.name("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.name("bookGenre"));
		
		for(WebElement book:bookList) {
			System.out.println(book.getText());
			assertFalse(book.getText().contains("Dracula"));	
		}	
	}
	
	@Test(priority=3)
	public void addBook_withBadAuthorData() {
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
		authorInput.sendKeys("");
		illustratorInput.sendKeys("House of Carfax");
		genreInput.sendKeys("Horror");
		
		submitBookButton.click();
		
		bookList = driver.findElements(By.id("bookList"));
		
		assertEquals(bookList.size(), 3);
		
		WebElement bookId = driver.findElement(By.name("bookId"));
		WebElement bookTitle = driver.findElement(By.name("bookTitle"));
		WebElement bookSeries = driver.findElement(By.name("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.name("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.name("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.name("bookGenre"));
		
		for(WebElement book:bookList) {
			System.out.println(book.getText());
			assertFalse(book.getText().contains("Bram Stoker"));	
		}	
	}
	
	@Test(priority=4)
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
		ArrayList<WebElement> bookField = new ArrayList<>();
		
		int index = 0;
		for(index=0; index <= bookList.size(); index++) {

			if(index == 0) {
				WebElement bookId = driver.findElement(By.id("bookId-0"));
				WebElement bookTitle = driver.findElement(By.id("bookTitle-0"));
				
				System.out.println(bookTitle.getText());
				System.out.println(bookId.getText());
			}
			if(index == 1) {
				WebElement bookId = driver.findElement(By.id("bookId-1"));
				WebElement bookTitle = driver.findElement(By.id("bookTitle-1"));
				
				System.out.println(bookTitle.getText());
				System.out.println(bookId.getText());
			}
			if(index == 2) {
				WebElement bookId = driver.findElement(By.id("bookId-2"));
				WebElement bookTitle = driver.findElement(By.id("bookTitle-2"));
				
				System.out.println(bookTitle.getText());
				System.out.println(bookId.getText());
			}
			if(index == 3) {
				WebElement bookId = driver.findElement(By.id("bookId-3"));
				WebElement bookTitle = driver.findElement(By.id("bookTitle-3"));
				WebElement bookSeries = driver.findElement(By.id("bookSeries-3"));
				WebElement bookAuthor = driver.findElement(By.id("bookAuthor-3"));
				WebElement bookIllustrator = driver.findElement(By.id("bookIllustrator-3"));
				WebElement bookGenre = driver.findElement(By.id("bookGenre-3"));
				
				
				System.out.println(bookTitle.getText());
				System.out.println(bookId.getText());
				
				if(bookTitle.getText().equals("Dracula")) {
					assertEquals(index, 3);
					assertEquals(bookId.getText(), "4");
					assertEquals(bookSeries.getText(), "Horror Classics");
					assertEquals(bookAuthor.getText(), "Bram Stoker");
					assertEquals(bookIllustrator.getText(), "House of Carfax");
					assertEquals(bookGenre.getText(), "Horror");
				}
			}
					
		}
	}
	
	@Test(priority=5)
	public void editBook_withBadTitleData() {
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
		
		WebElement bookId = driver.findElement(By.name("bookId"));
		WebElement bookTitle = driver.findElement(By.name("bookTitle"));
		WebElement bookSeries = driver.findElement(By.name("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.name("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.name("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.name("bookGenre"));
				
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		
		int index = 0;
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				WebElement editBtn = driver.findElement(By.id("editBtn-0"));
				editBtn.click();
			}
		}
		
		WebElement updateBookButton = driver.findElement(By.name("updateBookBtn"));
				
		titleInput.clear();
		
		titleInput.sendKeys("");
		
		updateBookButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.textToBe(By.name("bookTitle"), "Frankenstein"));
		
		driver.navigate().refresh();
		
		bookId = driver.findElement(By.name("bookId"));
		bookTitle = driver.findElement(By.id("bookTitle-0"));
		bookAuthor = driver.findElement(By.id("bookAuthor-0"));
		
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				System.out.println(bookTitle.getText());
				assertEquals(bookTitle.getText(), "Frankenstein");
				assertEquals(bookAuthor.getText(), "Mary Shelly");	
			}
		}
	}
	
	@Test(priority=6)
	public void editBook_withBadAuthorData() {
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
		
		WebElement bookId = driver.findElement(By.name("bookId"));
		WebElement bookTitle = driver.findElement(By.name("bookTitle"));
		WebElement bookSeries = driver.findElement(By.name("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.name("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.name("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.name("bookGenre"));
				
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		
		int index = 0;
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				WebElement editBtn = driver.findElement(By.id("editBtn-0"));
				editBtn.click();
			}
		}
		
		WebElement updateBookButton = driver.findElement(By.name("updateBookBtn"));
				
		authorInput.clear();
		
		authorInput.sendKeys("");
		
		updateBookButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.textToBe(By.name("bookAuthor"), "Mary Shelly"));
		
		driver.navigate().refresh();
		
		bookId = driver.findElement(By.name("bookId"));
		bookTitle = driver.findElement(By.id("bookTitle-0"));
		bookAuthor = driver.findElement(By.id("bookAuthor-0"));
		
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				System.out.println(bookTitle.getText());
				assertEquals(bookTitle.getText(), "Frankenstein");
				assertEquals(bookAuthor.getText(), "Mary Shelly");	
			}
		}
	}
	
	@Test(priority=7)
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
		
		WebElement bookId = driver.findElement(By.name("bookId"));
		WebElement bookTitle = driver.findElement(By.name("bookTitle"));
		WebElement bookSeries = driver.findElement(By.name("bookSeries"));
		WebElement bookAuthor = driver.findElement(By.name("bookAuthor"));
		WebElement bookIllustrator = driver.findElement(By.name("bookIllustrator"));
		WebElement bookGenre = driver.findElement(By.name("bookGenre"));
				
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		
		int index = 0;
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				WebElement editBtn = driver.findElement(By.id("editBtn-0"));
				editBtn.click();
			}
		}
		
		WebElement updateBookButton = driver.findElement(By.name("updateBookBtn"));
				
		titleInput.clear();
		authorInput.clear();
		
		titleInput.sendKeys("Frank");
		authorInput.sendKeys("Mary Stein");
		
		updateBookButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.textToBe(By.name("bookTitle"), "Frank"));
		
		driver.navigate().refresh();
		
		bookId = driver.findElement(By.name("bookId"));
		bookTitle = driver.findElement(By.id("bookTitle-0"));
		bookAuthor = driver.findElement(By.id("bookAuthor-0"));
		
		for(index=0; index <= bookList.size(); index++) {
			if(bookId.getText().equals("1")) {
				System.out.println(bookTitle.getText());
				assertEquals(bookTitle.getText(), "Frank");
				assertEquals(bookAuthor.getText(), "Mary Stein");	
			}
		}
	}
	
	@Test(priority=8)
	public void deleteBook() {
		driver.get("http://localhost:8081/");
		
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submit = driver.findElement(By.name("submitLogIn"));
		
		username.sendKeys("superduper");
		password.sendKeys("llllllll");
		
		submit.click();
		
		WebElement listButton = driver.findElement(By.className("BookListButton"));
		
		listButton.click();
		
		List<WebElement> bookList = new ArrayList<>();
		bookList = driver.findElements(By.id("bookList"));
		int size1 = bookList.size();
		System.out.println(size1);
		WebElement deleteBtn = driver.findElement(By.id("deleteBtn-2"));
		deleteBtn.click();
		bookList = driver.findElements(By.id("bookList"));
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("bookList"), 4));
		//Have this end with ` (By.id("bookList"), 3)); ` if running this test by itself;
		//Have this end with ` (By.id("bookList"), 4)); ` if running the full test suite.
		
		bookList = driver.findElements(By.id("bookList"));
		int size2 = bookList.size();
		System.out.println(size2);
		boolean truth = size1 > size2;
		assertTrue(truth);
		
	}
}
