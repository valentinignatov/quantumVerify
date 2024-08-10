package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageFactory {

	public static <T extends Page> T getPage(String pageType, WebDriver driver) {
		switch (pageType.toLowerCase()) {
		
		case "login":
			return (T) new LoginPage(driver);

		case "otp":
			// return new OtpPage(driver);
			
		case "oauth":
			// return new OAuthPage(driver);
			
		case "webinput":
			return (T) new WebInputPage(driver);
			
		case "addremove":
			return (T) new AddRemovePage(driver);
			
		default:
			throw new IllegalArgumentException("Unknown page type: " + pageType);
		}
	}

}
