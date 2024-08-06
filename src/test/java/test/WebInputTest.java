package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import config.BaseChromeConf;
import config.page.PageFactory;
import config.page.WebInputPage;
import util.DateFormatChanger;
import org.testng.Assert;

public class WebInputTest extends BaseChromeConf {

	@org.testng.annotations.Test
	public void input() {
		
		WebInputPage webInputsPage = (WebInputPage)PageFactory.getPage("webInput", driver);
		
		webInputsPage.get();
		
		webInputsPage.scroll(wait, js, By.id("input-date"));
		
		String number = "10";
		String textInput = "Valentin Ignatov Test";
		String password = "superPas";
		
		webInputsPage.insertNumber(number);
		webInputsPage.insertNumberIncrement(20);
		webInputsPage.insertNumberDecrement(10);
		
		webInputsPage.insertText(textInput);
		
		webInputsPage.insertPassword(password);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = formatter.format(new Date());
		webInputsPage.inputDate(formattedDate);
		
		webInputsPage.displayOutput();
		
		Assert.assertEquals("20", webInputsPage.getInsertedNumber());
		
		Assert.assertEquals(textInput, webInputsPage.getInsertedText());
		
		Assert.assertEquals(password, webInputsPage.getInsertedPassword());
		
		Assert.assertEquals(formattedDate, new DateFormatChanger().changeDateFormat(webInputsPage.getInsertedDate()));
		
	}
}
