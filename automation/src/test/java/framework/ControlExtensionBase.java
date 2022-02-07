package framework;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class ControlExtensionBase {
	protected WebDriver driver;
	
	public void select(WebElement element) {
		Actions action = new Actions(driver);
		action.click(element);
		action.perform();
	}

	public boolean isSelected(WebElement element) {
		return element.isSelected();
	}
}
