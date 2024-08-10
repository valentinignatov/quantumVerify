package steps;

import pageobjects.DragAndDropCirclesPage;
import hooks.SeleniumHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class CircleSequenceDragAndDropSteps {
	//mvn test -Dcucumber.features=src/test/resources/features/circle_sequence_drag_and_drop.feature
    
    private DragAndDropCirclesPage dragAndDropCirclesPage;

    public CircleSequenceDragAndDropSteps() {
        this.dragAndDropCirclesPage = new DragAndDropCirclesPage(SeleniumHooks.getDriver());
    }

    @Given("I am on the Drag and Drop Circles page")
    public void i_am_on_the_drag_and_drop_circles_page() {
        dragAndDropCirclesPage.navigateTo();
    }

    @When("I drag the circles in sequence {string} to the target area")
    public void i_drag_circles_to_the_target_area(String sequence) {
        dragAndDropCirclesPage.dragCirclesInSequence(sequence);
    }

    @Then("the circles should be successfully dropped on the target in the order {string}")
    public void the_circles_should_be_successfully_dropped_on_the_target_in_order(String sequence) {
        boolean isOrderCorrect = dragAndDropCirclesPage.verifyCirclesOrder(sequence.split(", "));
        Assert.assertTrue(isOrderCorrect, "The drop sequence was not successful for: " + sequence);
    }

    @And("I refresh the page")
    public void i_refresh_the_page() {
        dragAndDropCirclesPage.refreshPage();
    }
}
