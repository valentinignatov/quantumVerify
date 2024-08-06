package config.page;

import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemovePage extends Page {
	
	@FindBy(xpath = "//button[text()='Add Element']")
	private WebElement addElement;
	
	@FindBy(className = "added-manually")
	private WebElement remvoeElement;

	public AddRemovePage(WebDriver driver) {
		super(driver);
	}
	
	public void get() {
		driver.get("https://practice.expandtesting.com/add-remove-elements");
		driver.manage().window().maximize();
	}
	
	public void addElement(int elementNr) {
		IntStream.rangeClosed(1, elementNr).forEach(i -> {
            addElement.click();
        });
	}
	
	public void removeElements(int elementNr) {
		IntStream.rangeClosed(1, elementNr).forEach(i -> {
			remvoeElement.click();
        });
	}
	
	public int checkAddedElements() {
		return driver.findElements(By.className("added-manually")).size();
	}
}
