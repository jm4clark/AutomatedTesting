package com.bae.selenium.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests {

	public static WebDriver driver;
	private String[] urls = {"https://www.google.com", "http://thedemosite.co.uk", "https://www.youidraw.com/apps/painter/", 
			"http://automationpractice.com/index.php", "https://www.phptravels.net/", "https://www.hl.co.uk/shares/stock-market-summary/ftse-100"
			,"http://www.practiceselenium.com/welcome.html"};

	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@Ignore
	@Test
	public void test1() throws InterruptedException {
		driver.get(urls[0]);

		WebElement search = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		search.sendKeys("very cute ducks");

		search.sendKeys(Keys.ENTER);

		driver.findElement(By.partialLinkText("images")).click();

		Thread.sleep(100);

		WebElement image = driver.findElement((By.xpath("//*[@id=\"mX9Zcc_tzn_AnM:\"]")));

		image.click();

		assertTrue(image.isDisplayed());

		Thread.sleep(500);
	}

	@Ignore
	@Test
	public void test2() throws InterruptedException {
		driver.get(urls[1]);

		Thread.sleep(500);

		WebElement addUser = driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();

		driver.findElement(By.name("username")).sendKeys("funny");

		driver.findElement(By.name("password")).sendKeys("haha");

		driver.findElement(By.name("FormsButton2")).click();

		driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		
		driver.findElement(By.name("username")).sendKeys("funny");

		driver.findElement(By.name("password")).sendKeys("haha");

		driver.findElement(By.name("FormsButton2")).click();
		
		//assertTrue(); **Successful Login**
		assertTrue(driver.findElement(By.xpath("//*[contains(text(),'" + "**Successful Login**" + "')]")).isDisplayed());
		
		Thread.sleep(2000);
	}
	
	@Ignore
	@Test
	public void test3() throws InterruptedException {
		driver.get(urls[3]);
		
		WebElement search = driver.findElement(By.name("search_query"));
		search.sendKeys("dress");
		search.submit();
		
		WebElement dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[2]/h5/a"));
		dress.click();
		
		driver.findElement(By.id("add_to_cart")).click();
		
		
		WebElement checkout = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Proceed to checkout")));
		checkout.click();
		
		
		Thread.sleep(2000);
	}
	
	
	@Test
	public void testHotel() throws InterruptedException { 
		driver.get(urls[4]);
		
		WebElement search = driver.findElement(By.xpath("//*[@id=\"s2id_autogen3\"]/a"));
		search.click();
		
		search = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
		search.sendKeys("London");
				
		WebElement london = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div"))); 

		london.click();
		
		WebElement checkIn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dpd1\"]/div/input")));
		checkIn.click();
		
		WebElement date1 = (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div[1]/table/tbody/tr[5]/td[6]")));
		date1.click();
		driver.findElement(By.xpath("/html/body/div[11]/div[1]/table/tbody/tr[6]/td[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"travellersInput\"]")).click();
		WebElement plus = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adultPlusBtn\"]")));
		plus.click();
		
		driver.findElement(By.xpath("//*[@id=\"hotels\"]/form/div[5]/button")).click();
				
		
		Thread.sleep(1000);
		
	}
	
	@Ignore
	@Test
	public void testStock() {
		driver.get(urls[5]);
	}
	@Ignore
	@Test
	public void testTea() {
		driver.get(urls[6]);
		
		
	}

	@Ignore
	@Test
	public void testDrawName() throws InterruptedException {
		driver.get(urls[2]);

		Thread.sleep(500);

		driver.findElement(By.id("brush")).click();
		Actions action = new Actions(driver);

		// J
		action.moveByOffset(600, 300).clickAndHold().moveByOffset(100, 0).perform();
		action.moveByOffset(-50, 0).moveByOffset(0, 100).perform();
		action.moveByOffset(-50, -50).release().perform();

		// A
		action.moveByOffset(100, 50).perform();
		action.clickAndHold().moveByOffset(25, -100).perform();
		action.moveByOffset(25, 100).release().perform();
		action.moveByOffset(-12, -25).clickAndHold().moveByOffset(-25, 0).release().perform();

		// M
		action.moveByOffset(75, 25).clickAndHold().moveByOffset(0, -100).perform();
		action.moveByOffset(25, 50).perform();
		action.moveByOffset(25, -50).perform();
		action.moveByOffset(0, 100).release().perform();

		// E
		action.moveByOffset(50, -100).clickAndHold().moveByOffset(0, 100).perform();
		action.moveByOffset(50, 0).release().perform();
		action.moveByOffset(-50, -50).clickAndHold().moveByOffset(35, 0).release().perform();
		action.moveByOffset(-35, -50).clickAndHold().moveByOffset(50, 0).release().perform();

		// S
		action.moveByOffset(100, 15).clickAndHold().moveByOffset(-5, -10).perform();// .moveByOffset(-75,15).perform();
		action.moveByOffset(-15, -5).clickAndHold().moveByOffset(-20, 0).clickAndHold().moveByOffset(-15, 5).perform();
		action.moveByOffset(-10, 15).clickAndHold().moveByOffset(5, 10).clickAndHold().moveByOffset(10, 10).perform();
		action.moveByOffset(15, 10).perform();
		action.moveByOffset(25, 15).perform();
		action.moveByOffset(5, 20).perform();
		action.moveByOffset(-10, 15).perform();
		action.moveByOffset(-15, 5).perform();
		action.moveByOffset(-20, 0).perform();
		action.moveByOffset(-15, -5).perform();
		action.moveByOffset(-5, -10).release().perform();

		// :)
		action.moveByOffset(200, -50).clickAndHold().moveByOffset(0, 5).release().perform();
		action.moveByOffset(50, -5).clickAndHold().moveByOffset(0, 5).release().perform();
		action.moveByOffset(-75, 20).clickAndHold().moveByOffset(5, 20).perform();
		action.moveByOffset(10, 15).clickAndHold().moveByOffset(15, 10).perform();
		action.moveByOffset(20, 5).clickAndHold().moveByOffset(20, -5).perform();
		action.moveByOffset(15, -10).clickAndHold().moveByOffset(10, -15).moveByOffset(5, -20).perform();

		Thread.sleep(2000);

	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}

}
