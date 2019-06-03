package com.bae.cucumber.tests;


import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class Tests {
	
	public static WebDriver driver;
	
	public static String url = "http://www.practiceselenium.com/welcome.html";
	

//	@Before
//	public static void setup() {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Admin\\Downloads\\chromedriver_win32/chromedriver.exe");
//		driver = new ChromeDriver();
//
//		driver.manage().window().maximize();
//	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get(url);
		
		assertEquals(url,driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		
		WebElement menu = driver.findElement(By.partialLinkText("Menu"));//xpath("//a[@href=" + "menu.html"+"\"]"));
		menu.click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		assertTrue(driver.getPageSource().contains("Green Tea") && driver.getPageSource().contains("Red Tea") && driver.getPageSource().contains("Oolong Tea"));
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		
		WebElement menu = driver.findElement(By.partialLinkText("Check Out"));
		menu.click();
		
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		assertTrue(driver.getCurrentUrl().equals("http://www.practiceselenium.com/check-out.html"));
	}
	
	
//	@After
//	public static void teardown() {
//		driver.quit();
//	}
}
