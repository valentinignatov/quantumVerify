package config.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.FancyNinjaDecrementor;
import util.FancyNinjaIncrementer;

public class WebInputPage extends Page {

	@FindBy(xpath = "//*[@id='input-number']")
	private WebElement numberInput;

	@FindBy(xpath = "//input[@name='input-text']")
	private WebElement textInput;

	@FindBy(id = "input-password")
	private WebElement passwordInput;

	@FindBy(id = "input-date")
	private WebElement dateInput;

	@FindBy(xpath = "//*[@id='output-number']")
	private WebElement numberOutput;

	@FindBy(xpath = "//strong[@id='output-text']")
	private WebElement textOutput;

	@FindBy(id = "output-password")
	private WebElement passwordOutput;

	@FindBy(id = "output-date")
	private WebElement dateOutput;
	
	@FindBy(id = "btn-display-inputs")
	private WebElement displayInputButton;

	public WebInputPage(WebDriver driver) {
		super(driver);
	}

	public void get() {
		driver.get("https://practice.expandtesting.com/inputs");
		driver.manage().window().maximize();
	}

	public void insertNumber(String text) {
		numberInput.sendKeys(text);
	}

	public void insertNumberIncrement(int numberToIncrement) {
		new FancyNinjaIncrementer().ultraFancyFor(0, numberToIncrement, index -> {
			numberInput.sendKeys(Keys.ARROW_UP);
		});
	}

	public void insertNumberDecrement(int numberToDecrement) {
		new FancyNinjaDecrementor().ultraFancyFor(0, numberToDecrement, index -> {
			numberInput.sendKeys(Keys.ARROW_DOWN);
		});
	}

	public void insertText(String text) {
		textInput.sendKeys(text);
	}

	public void insertPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public String getInsertedNumber() {
		return numberOutput.getText();
	}

	public String getInsertedText() {
		return textOutput.getText();
	}

	public String getInsertedPassword() {
		return passwordOutput.getText();
	}

	public String getInsertedDate() {
		return dateOutput.getText();
	}

	public void inputDate(String formattedDate) {
		dateInput.sendKeys(formattedDate);
	}
	
	public void displayOutput() {
		displayInputButton.click();
	}

}
