package test;

import java.util.Collections;
import java.util.List;
import org.testng.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.BaseChromeConf;

public class AddRemoveElementsTest extends BaseChromeConf {
	
//	 public static void main(String[] args) {
//	        TestNG testng = new TestNG();
//	        testng.setTestSuites(Collections.singletonList("testng.xml"));
//	        testng.run();
//	    }

//	@Test
	public void testAddAndRemoveElements() throws InterruptedException {
		// Navigate to the web page
		driver.get("https://practice.expandtesting.com/add-remove-elements");

		// Locate the Add Element button
		WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

		// Add 100 elements
		for (int i = 0; i < 100; i++) {
			addButton.click();
		}

		// Verify 100 elements are added
		List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
		Assert.assertEquals(deleteButtons.size(), 100, "Number of added elements should be 100");

		// Remove all 100 elements
		for (int i = 0; i < 100; i++) {
			deleteButtons.get(i).click();
		}

		// Verify all elements are removed
		deleteButtons = driver.findElements(By.className("added-manually"));
		Assert.assertEquals(deleteButtons.size(), 0, "All elements should be removed");
	}

}
