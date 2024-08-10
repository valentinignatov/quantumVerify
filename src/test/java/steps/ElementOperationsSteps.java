package steps;

import hooks.SeleniumHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddRemovePage;
import pageobjects.PageFactory;
import pageobjects.WebInputPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ElementOperationsSteps  {
    
    private WebDriver driver = SeleniumHooks.getDriver();
    private AddRemovePage addRemPage;

    @Given("I am on the Add Remove page")
    public void i_am_on_the_add_remove_page() {
        addRemPage = (AddRemovePage) PageFactory.getPage("addRemove", driver);
        addRemPage.get();
    }

    @When("I add {int} elements")
    public void i_add_elements(Integer elements) {
        addRemPage.addElement(elements);
    }

    @Then("the number of displayed elements should be {int}")
    public void the_number_of_displayed_elements_should_be(Integer expectedCount) {
        Assert.assertEquals(addRemPage.checkAddedElements(), expectedCount.intValue());
    }

    @When("I remove all {int} elements")
    public void i_remove_all_elements(Integer elements) {
        addRemPage.removeElements(elements);
    }

    @Then("no elements should be displayed")
    public void no_elements_should_be_displayed() {
        Assert.assertEquals(addRemPage.checkAddedElements(), 0);
    }
}
