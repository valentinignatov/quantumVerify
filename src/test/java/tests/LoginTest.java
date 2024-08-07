package tests;

import config.BaseTestConf;
import config.page.LoginPage;
import config.page.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestConf {

	@Test
	public void logIn() {
		LoginPage loginPage = (LoginPage) PageFactory.getPage("login", driver);

		loginPage.get();
		loginPage.scroll(wait, js);

		loginPage.enterUsername("practice");

		loginPage.enterPassword("SuperSecretPassword!");

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.findSuccesText(), "You logged into a secure area!");
	}
	//TODO add db and csv file support
}
