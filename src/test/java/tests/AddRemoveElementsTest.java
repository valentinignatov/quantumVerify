package tests;

import config.page.*;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import config.BaseChromeConf;

public class AddRemoveElementsTest extends BaseChromeConf {

	@Test
	public void testAddAndRemoveElements() throws InterruptedException {
		
		AddRemovePage addRemPage = new AddRemovePage(driver);
		
		addRemPage.get();
		
		int elements = 100;
		
		addRemPage.addElement(elements);
		
		Assert.assertEquals(addRemPage.checkAddedElements(), 100, "Number of added elements should be 100");
		
		addRemPage.removeElements(elements);
		
		Assert.assertEquals(addRemPage.checkAddedElements(), 0, "\"All elements should be removed");
	}

}
