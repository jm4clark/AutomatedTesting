package com.bae.cucumber.tests;


import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class ParamTests {
	public static WebDriver driver;
	
	private String search; 
	
	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.get(arg1);
		//assertTrue(driver.getCurrentUrl().equals(arg1));
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) {
		WebElement search = driver.findElement(By.id("sb_form_q"));
		search.sendKeys(arg1);
		this.search = arg1;
		
		WebElement searchButton = driver.findElement(By.id("sb_form_go"));
		searchButton.click();
		Actions action = new Actions(driver);
		
		
		//action.click(search).keyDown(arg1).click(searchButton).perform();
		//action.keyDown(search,Keys.chord(arg1)).perform();
		//action.click(searchButton).perform();
		
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search()  {
		//WebElement result = new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("b_results")));
		//assertTrue(driver.getPageSource().contains(this.search));
		assertTrue(driver.getTitle().contains(this.search));
	}
	
	@After
	public static void teardown() {
		driver.close();
	}
}
