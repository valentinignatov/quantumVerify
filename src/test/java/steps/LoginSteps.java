package steps;

import config.handler.AdHandler;
import hooks.SeleniumHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

	private static final Logger logger = LoggerFactory.getLogger(SeleniumHooks.class);

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private AdHandler adHandler;
	private LoginPage loginPage;

	public LoginSteps() {
		this.driver = SeleniumHooks.getDriver();
		this.wait = SeleniumHooks.getWait();
		this.js = SeleniumHooks.getJs();
		this.adHandler = SeleniumHooks.getAdHandler();
		this.loginPage = (LoginPage) PageFactory.getPage("login", driver);
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage.get();
	}

	@When("I enter the username {string}")
	public void i_enter_the_username(String username) {
		loginPage.scroll(wait, js);
		loginPage.enterUsername(username);
	}

	@When("I enter the password {string}")
	public void i_enter_the_password(String password) {
		loginPage.enterPassword(password);
	}

	@Then("I should see a success message {string}")
	public void i_should_see_a_success_message(String expectedMessage) {
		loginPage.clickLogin();
		Assert.assertEquals(loginPage.findSuccesText(), expectedMessage);
	}
	// TODO add db and csv file support
	// TODO fix cross browsing error, run sequentially
	// TODO fix run tests via maven
}
