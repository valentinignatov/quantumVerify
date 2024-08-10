package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class DragAndDropCirclesPage extends Page {
    
	@FindBy(xpath = "//*[@id='target']")
	private WebElement targetArea;
	
    private String sourceCircleLocatorTemplate = "//*[@id='source']/div[contains(@class, '%s')]";

    public DragAndDropCirclesPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");
        System.out.println("Navigated to the page.");
    }

    public void dragCircleToTarget(String color) {
        try {
            WebElement sourceCircle = driver.findElement(By.xpath(String.format(sourceCircleLocatorTemplate, color.trim())));
            new Actions(driver).dragAndDrop(sourceCircle, targetArea).perform();
            System.out.println("Dragged " + color + " circle to target.");
        } catch (Exception e) {
            System.out.println("Failed to drag " + color + ": " + e.getMessage());
        }
    }

    public void dragCirclesInSequence(String sequence) {
        String[] colors = sequence.split(", ");
        for (String color : colors) {
            dragCircleToTarget(color);
        }
    }

    public boolean verifyCirclesOrder(String[] expectedOrder) {
        List<WebElement> droppedCircles = driver.findElements(By.xpath("//*[@id='target']/div"));
        List<String> actualOrder = droppedCircles.stream().map(e -> e.getAttribute("class")).collect(Collectors.toList());
        System.out.println("Expected Order: " + List.of(expectedOrder));
        System.out.println("Actual Order: " + actualOrder);
        return actualOrder.equals(List.of(expectedOrder));
    }

    public void refreshPage() {
        driver.navigate().refresh();
        System.out.println("Page refreshed.");
    }
}
