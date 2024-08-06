package tests;

import org.openqa.selenium.By;

import config.BaseChromeConf;
import config.page.LoginPage;
import config.page.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseChromeConf {

	@Test
	public void logIn() {
		LoginPage loginPage = (LoginPage) PageFactory.getPage("login", driver);

		loginPage.get();
		loginPage.scroll(wait, js, By.xpath("//*[@id=\"login\"]/button"));
		adHandler.closeAdIfPresent();

		loginPage.enterUsername("practice");
		adHandler.closeAdIfPresent();

		loginPage.enterPassword("SuperSecretPassword!");
		adHandler.closeAdIfPresent();

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.findSuccesText(), "You logged into a secure area!");
	}

}
