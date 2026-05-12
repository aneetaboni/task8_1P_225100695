package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestStemGameSelenium {

	private WebDriver driver;
	private WebDriverWait wait;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private void loginSuccessfully() {
		driver.get("http://127.0.0.1:8080/login");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		driver.findElement(By.id("username")).sendKeys("aneeta");
		driver.findElement(By.id("passwd")).sendKeys("1234");

		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('dob').value='2001-03-19';");

		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/q1"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("number1")));
	}

	@Test
	public void testSuccessfulFullGameFlow() {
		loginSuccessfully();

		driver.findElement(By.name("number1")).sendKeys("2");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("6");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/q2"));

		driver.findElement(By.name("number1")).sendKeys("7");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("3");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/q3"));

		driver.findElement(By.name("number1")).sendKeys("3");
		driver.findElement(By.name("number2")).sendKeys("4");
		driver.findElement(By.name("result")).sendKeys("12");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/"));
		Assert.assertTrue(driver.getPageSource().contains("Server is running"));
	}

	@Test
	public void testWrongAnswerStaysOnQ1() {
		loginSuccessfully();

		driver.findElement(By.name("number1")).sendKeys("1");
		driver.findElement(By.name("number2")).sendKeys("2");
		driver.findElement(By.name("result")).sendKeys("7");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/q1"));
		Assert.assertTrue(driver.getPageSource().contains("Wrong answer, try again."));
	}

	@Test
	public void testEmptyInputStaysOnQ1() {
		loginSuccessfully();

		driver.findElement(By.cssSelector("input[type='submit']")).click();

		wait.until(ExpectedConditions.urlContains("/q1"));
		Assert.assertTrue(driver.getPageSource().contains("Please enter valid numbers."));
	}
}