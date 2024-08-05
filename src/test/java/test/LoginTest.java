package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import config.*;
import config.page.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseChromeConf {

	@Test
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

		assertEquals(loginPage.findSuccesText(), "You logged into a secure area!");
	}

}
