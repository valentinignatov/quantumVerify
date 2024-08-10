package steps;

import config.BaseTestConf;
import config.page.LoginPage;
import config.page.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSteps extends BaseTestConf {

	LoginPage loginPage;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage = (LoginPage) PageFactory.getPage("login", driver);
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
