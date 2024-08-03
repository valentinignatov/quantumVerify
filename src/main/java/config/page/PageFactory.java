package config.page;

import org.openqa.selenium.WebDriver;

public class PageFactory {

	public static Page getPage(String pageType, WebDriver driver) {
		switch (pageType.toLowerCase()) {
		
		case "login":
			return new LoginPage(driver);

		case "otp":
			// return new OtpPage(driver);
			
		case "oauth":
			// return new OAuthPage(driver);
			
		default:
			throw new IllegalArgumentException("Unknown page type: " + pageType);
		}
	}

}
