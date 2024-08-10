package steps;

import config.page.WebInputPage;
import config.page.PageFactory;
import hooks.SeleniumHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import util.DateFormatChanger;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebInputSteps {
    private WebDriver driver = SeleniumHooks.getDriver();
    private WebDriverWait wait = SeleniumHooks.getWait();
    private JavascriptExecutor js = SeleniumHooks.getJs();
    private WebInputPage webInputsPage;

    @Given("I am on the WebInput page")
    public void i_am_on_the_web_input_page() {
        webInputsPage = (WebInputPage) PageFactory.getPage("webInput", driver);
        webInputsPage.get();
        webInputsPage.scroll(wait, js);
    }

    @When("I insert number {string}")
    public void i_insert_number(String number) {
        webInputsPage.insertNumber(number);
    }

    @When("I increment number by {int}")
    public void i_increment_number_by(int increment) {
        webInputsPage.insertNumberIncrement(increment);
    }

    @When("I decrement number by {int}")
    public void i_decrement_number_by(int decrement) {
        webInputsPage.insertNumberDecrement(decrement);
    }

    @When("I insert text {string}")
    public void i_insert_text(String text) {
        webInputsPage.insertText(text);
    }

    @When("I insert password {string}")
    public void i_insert_password(String password) {
        webInputsPage.insertPassword(password);
    }

    @When("I insert today's date")
    public void i_insert_todays_date() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = formatter.format(new Date());
        webInputsPage.inputDate(formattedDate);
    }
    
    @And("I display the output")
    public void i_display_the_output() {
        webInputsPage.displayOutput();
    }

    @Then("the number displayed should be {string}")
    public void the_number_displayed_should_be(String expectedNumber) {
        Assert.assertEquals(webInputsPage.getInsertedNumber(), expectedNumber);
    }

    @Then("the text displayed should be {string}")
    public void the_text_displayed_should_be(String expectedText) {
        Assert.assertEquals(webInputsPage.getInsertedText(), expectedText);
    }

    @Then("the password displayed should be {string}")
    public void the_password_displayed_should_be(String expectedPassword) {
        Assert.assertEquals(webInputsPage.getInsertedPassword(), expectedPassword);
    }

    @Then("the date displayed should match today's date")
    public void the_date_displayed_should_match_todays_date() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String expectedDate = formatter.format(new Date());
        Assert.assertEquals(new DateFormatChanger().changeDateFormat(webInputsPage.getInsertedDate()), expectedDate);
    }
}
