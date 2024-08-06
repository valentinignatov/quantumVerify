package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.BaseChromeConf;

public class AddRemoveElementsTest extends BaseChromeConf {

	@Test
	public void testAddAndRemoveElements() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/add-remove-elements");

		WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));

		for (int i = 0; i < 100; i++) {
			addButton.click();
		}

		List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
		Assert.assertEquals(deleteButtons.size(), 100, "Number of added elements should be 100");

		for (int i = 0; i < 100; i++) {
			deleteButtons.get(i).click();
		}

		deleteButtons = driver.findElements(By.className("added-manually"));
		Assert.assertEquals(deleteButtons.size(), 0, "All elements should be removed");
	}

}
