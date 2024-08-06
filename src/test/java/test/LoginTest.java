package test;

import org.openqa.selenium.By;

import config.BaseChromeConf;
import config.page.LoginPage;
import config.page.PageFactory;
import org.testng.Assert;

public class LoginTest extends BaseChromeConf {

	@org.testng.annotations.Test
	public void logIn() {
		LoginPage loginPage = (LoginPage) PageFactory.getPage("login", driver);

		loginPage.get();
		adHandler.closeAdIfPresent();

		loginPage.enterUsername("practice");
		adHandler.closeAdIfPresent();

		loginPage.enterPassword("SuperSecretPassword!");
		adHandler.closeAdIfPresent();

		loginPage.scroll(wait, js, By.xpath("//*[@id=\"login\"]/button"));

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		loginPage.clickLogin();

		Assert.assertEquals(loginPage.findSuccesText(), "You logged into a secure area!");
	}

}
