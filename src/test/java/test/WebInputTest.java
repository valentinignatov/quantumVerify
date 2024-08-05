package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import config.*;
import config.page.*;
import util.DateFormatChanger;

public class WebInputTest extends BaseChromeConf {

	@Test
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
		
		assertEquals("20", webInputsPage.getInsertedNumber());
		
		assertEquals(textInput, webInputsPage.getInsertedText());
		
		assertEquals(password, webInputsPage.getInsertedPassword());
		
		assertEquals(formattedDate, new DateFormatChanger().changeDateFormat(webInputsPage.getInsertedDate()));
		
	}
}
