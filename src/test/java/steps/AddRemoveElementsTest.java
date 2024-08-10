package steps;

import config.page.AddRemovePage;
import hooks.SeleniumHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddRemoveElementsTest {
    
    private WebDriver driver = SeleniumHooks.getDriver();
    private AddRemovePage addRemPage;

    @Given("I am on the Add Remove page")
    public void i_am_on_the_add_remove_page() {
        addRemPage = new AddRemovePage(driver);
        addRemPage.get();
    }

    @Given("I have added {int} elements")
    public void i_have_added_elements(Integer elements) {
        addRemPage = new AddRemovePage(driver);
        addRemPage.get();
        addRemPage.addElement(elements);
    }

    @When("I add {int} elements")
    public void i_add_elements(Integer elements) {
        addRemPage.addElement(elements);
    }

    @When("I remove all {int} elements")
    public void i_remove_all_elements(Integer elements) {
        addRemPage.removeElements(elements);
    }

    @Then("the number of displayed elements should be {int}")
    public void the_number_of_displayed_elements_should_be(Integer expectedCount) {
        Assert.assertEquals(addRemPage.checkAddedElements(), expectedCount.intValue(), 
            "Number of added elements should match expected");
    }

    @Then("no elements should be displayed")
    public void no_elements_should_be_displayed() {
        Assert.assertEquals(addRemPage.checkAddedElements(), 0, 
            "All elements should be removed");
    }
}
