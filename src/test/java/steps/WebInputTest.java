package steps;

import java.text.SimpleDateFormat;
import java.util.Date;

import config.BaseTestConf;
import config.page.PageFactory;
import config.page.WebInputPage;
import util.DateFormatChanger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebInputTest extends BaseTestConf {

	@Test
	public void input() {
		
		WebInputPage webInputsPage = (WebInputPage)PageFactory.getPage("webInput", driver);
		
		webInputsPage.get();
		
		webInputsPage.scroll(wait, js);
		
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
